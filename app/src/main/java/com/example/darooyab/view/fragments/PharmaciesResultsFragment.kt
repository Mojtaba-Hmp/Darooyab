package com.example.darooyab.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.darooyab.adapter.PharmaciesAdapter
import com.example.darooyab.data.DataSource
import com.example.darooyab.databinding.FragmentPharmaciesResultsBinding
import com.example.darooyab.model.Pharmacy

class PharmaciesResultsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentPharmaciesResultsBinding.inflate(LayoutInflater.from(activity),container, false)

        val args: PharmaciesResultsFragmentArgs by navArgs()
        val drugId = args.drugId

        val pharmaciesList = DataSource.getPharmacies()

        val pharmaciesResultList = mutableListOf<Pharmacy>()
        for (i in pharmaciesList) {
            if (i.drugsList.contains(drugId)
            ) {
                pharmaciesResultList.add(Pharmacy(i.id,i.name, i.address, i.phone,i.drugsList))
            }
        }

        if (pharmaciesResultList.isEmpty()){
            binding.subTextView.visibility = View.VISIBLE
        } else {
            binding.subTextView.visibility = View.GONE
        }

        binding.pharmaciesResultsRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.pharmaciesResultsRecyclerView.adapter = PharmaciesAdapter(pharmaciesResultList)


        return binding.root
    }

}