package com.example.darooyab.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.darooyab.adapter.MedicineAdapter
import com.example.darooyab.data.DataSource
import com.example.darooyab.databinding.FragmentMedicineResultsBinding
import com.example.darooyab.model.Medicine

class MedicineResultsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentMedicineResultsBinding
            .inflate(LayoutInflater.from(activity), container, false)


        val args: MedicineResultsFragmentArgs by navArgs()
        val medicineName = args.medicineName


        val medicineList = DataSource.getMedicines()


        val resultsList = mutableListOf<Medicine>()

        for (i in medicineList) {
            if (i.engName.contains(medicineName, ignoreCase = true) ||
                i.faName.contains(medicineName, ignoreCase = true) ||
                i.dosage.contains(medicineName, ignoreCase = true)
            ) {
                resultsList.add(Medicine(i.id,i.engName, i.faName, i.dosage,i.type))
            }
        }

        if (resultsList.isEmpty()) {
            binding.subTextView.visibility = View.VISIBLE
        } else {
            binding.subTextView.visibility = View.GONE
        }



        binding.resultsRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.resultsRecyclerView.adapter = MedicineAdapter(resultsList) { drugId ->
            val action = MedicineResultsFragmentDirections
                .actionMedicineResultsFragmentToPharmaciesResultsFragment(drugId)

            findNavController().navigate(action)}




        return binding.root
    }
}
