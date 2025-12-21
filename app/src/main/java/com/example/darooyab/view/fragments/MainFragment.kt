package com.example.darooyab.view.fragments

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
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

        binding.searchEditText.setOnEditorActionListener(object: TextView.OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if(actionId == EditorInfo.IME_ACTION_DONE || event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER){
                    binding.searchButton.performClick()
                    return true
                }
                return false
            }
        })

        return binding.root
    }
}