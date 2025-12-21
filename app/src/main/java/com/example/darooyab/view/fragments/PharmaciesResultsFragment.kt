package com.example.darooyab.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.darooyab.adapter.PharmaciesAdapter
import com.example.darooyab.databinding.FragmentPharmaciesResultsBinding
import com.example.darooyab.model.Pharmacy

class PharmaciesResultsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentPharmaciesResultsBinding.inflate(LayoutInflater.from(activity),container, false)

        val args: PharmaciesResultsFragmentArgs by navArgs()
        val drugId = args.drugId

        val pharmaciesList = mutableListOf<Pharmacy>()
        pharmaciesList.add(Pharmacy(1,"سامان","خیابان انقلاب","77886655",mutableListOf(1,3,5,7,9,11,15,17,23)))
        pharmaciesList.add(Pharmacy(2,"آسمان","بلوار کشاورز","88776655",mutableListOf(2,4,6,8,9,10,12,18,22,24)))
        pharmaciesList.add(Pharmacy(3,"ابن سینا","خیابان پیروزی","33445566",mutableListOf(3,6,9,12,15,18,21,24)))
        pharmaciesList.add(Pharmacy(4,"ایران","خیابان فلسطین","11223344",mutableListOf(4,8,12,16,20,24)))
        pharmaciesList.add(Pharmacy(5,"کیوان","خیابان آفریقا","22334455",mutableListOf(5,10,15,20,25)))
        pharmaciesList.add(Pharmacy(6,"نرگس","خیابان ولیعصر","99887766",mutableListOf(2,6,10,14,18,22)))

        val pharmaciesResultList = mutableListOf<Pharmacy>()
        for (i in pharmaciesList) {
            if (i.drugsList.contains(drugId)
            ) {
                pharmaciesResultList.add(Pharmacy(i.id,i.name, i.address, i.phone,i.drugsList))
            }
        }

        binding.pharmaciesResultsRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.pharmaciesResultsRecyclerView.adapter = PharmaciesAdapter(pharmaciesResultList)


        return binding.root
    }

}