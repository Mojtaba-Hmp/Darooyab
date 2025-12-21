package com.example.darooyab.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.darooyab.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentMainBinding.inflate(LayoutInflater.from(activity),container, false)

        binding.searchButton.setOnClickListener {
            val searchedItem = binding.searchEditText.text.toString()
            if (searchedItem.isNotEmpty()) {
                val action = MainFragmentDirections.actionMainFragmentToMedicineResultsFragment(searchedItem)
                findNavController().navigate(action)
            }
        }

        return binding.root
    }
}