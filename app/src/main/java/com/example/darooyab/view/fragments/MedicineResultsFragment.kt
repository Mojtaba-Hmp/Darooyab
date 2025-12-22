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
import com.example.darooyab.databinding.FragmentMedicineResultsBinding
import com.example.darooyab.model.Medicine

class MedicineResultsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentMedicineResultsBinding
            .inflate(LayoutInflater.from(activity), container, false)


        val args: MedicineResultsFragmentArgs by navArgs()
        val medicineName = args.medicineName


        val medicineList = mutableListOf<Medicine>()
        medicineList.add(Medicine(1,"Acetaminophen", "استامینوفن", "325mg","قرص"))
        medicineList.add(Medicine(2,"Acetaminophen", "استامینوفن", "500mg","قرص"))
        medicineList.add(Medicine(3,"Acetaminophen", "استامینوفن", "کدئين","قرص"))
        medicineList.add(Medicine(4,"Acetaminophen", "استامینوفن", "60mL","شربت"))
        medicineList.add(Medicine(5,"Acetaminophen", "استامینوفن", "120mL","شربت"))
        medicineList.add(Medicine(6,"Acetaminophen", "استامینوفن", "100mg","قطره"))
        medicineList.add(Medicine(7,"Acetaminophen", "استامینوفن", "75mg","شیاف"))
        medicineList.add(Medicine(8,"Acetaminophen", "استامینوفن", "125mg","شیاف"))
        medicineList.add(Medicine(9,"Acetaminophen", "استامینوفن", "325mg","شیاف"))
        medicineList.add(Medicine(10,"Ibuprofen", "بروفن", "200mg","قرص"))
        medicineList.add(Medicine(11,"Ibuprofen", "بروفن", "400mg","قرص"))
        medicineList.add(Medicine(12,"Cefixime", "سفکسیم", "200mg","قرص"))
        medicineList.add(Medicine(13,"Cefixime", "سفکسیم", "400mg","قرص"))
        medicineList.add(Medicine(14,"Diphenhydramine", "دیفن هیدرامین", "60mL","شربت"))
        medicineList.add(Medicine(15,"Expectorant", "اکسپکتورانت", "60mL","شربت"))
        medicineList.add(Medicine(16,"Tramadol", "ترامادول", "100mg","قرص"))
        medicineList.add(Medicine(17,"Oxycodone", "اکسی کدون", "5mg","قرص"))
        medicineList.add(Medicine(18,"Valsartan", "والزارتان", "80mg","قرص"))
        medicineList.add(Medicine(19,"Valsartan", "والزارتان", "160mg","قرص"))
        medicineList.add(Medicine(20,"Pantoprazole", "پنتوپرازول", "20mg","قرص"))
        medicineList.add(Medicine(21,"Pantoprazole", "پنتوپرازول", "40mg","قرص"))
        medicineList.add(Medicine(22,"Metformin", "متفورمین", "500mg","قرص"))
        medicineList.add(Medicine(23,"Metformin", "متفورمین", "1000mg","قرص"))
        medicineList.add(Medicine(24,"Sertraline", "سرترالین", "50mg","قرص"))
        medicineList.add(Medicine(25,"Sertraline", "سرترالین", "100mg","قرص"))


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