package com.example.darooyab.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.darooyab.adapter.MyAdapter
import com.example.darooyab.databinding.FragmentResultsBinding
import com.example.darooyab.model.Medicine

class ResultsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            FragmentResultsBinding.inflate(LayoutInflater.from(activity), container, false)


        val args: ResultsFragmentArgs by navArgs()
        val medicineName = args.medicineName


        val medicineList = mutableListOf<Medicine>()
        medicineList.add(Medicine("Acetaminophen", "استامینوفن", "325mg","قرص"))
        medicineList.add(Medicine("Acetaminophen", "استامینوفن", "500mg","قرص"))
        medicineList.add(Medicine("Acetaminophen", "استامینوفن", "-","قطره"))
        medicineList.add(Medicine("Ibuprofen", "بروفن", "200mg","قرص"))
        medicineList.add(Medicine("Ibuprofen", "بروفن", "400mg","قرص"))
        medicineList.add(Medicine("Cefixime", "سفکسیم", "200mg","قرص"))
        medicineList.add(Medicine("Cefixime", "سفکسیم", "400mg","قرص"))

        val resultsList = mutableListOf<Medicine>()

        for (i in medicineList) {
            if (i.engName.contains(medicineName, ignoreCase = true) ||
                i.faName.contains(medicineName, ignoreCase = true) ||
                i.dosage.contains(medicineName, ignoreCase = true)
            ) {
                resultsList.add(Medicine(i.engName, i.faName, i.dosage,i.type))
            }
        }

        if (resultsList.isEmpty()) {
            binding.subTextView.visibility = View.VISIBLE
        } else {
            binding.subTextView.visibility = View.GONE
        }



        binding.resultsRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.resultsRecyclerView.adapter = MyAdapter(resultsList)





        return binding.root
    }
}