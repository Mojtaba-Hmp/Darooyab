package com.example.darooyab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.darooyab.databinding.PharmaciesRecyclerLayoutBinding
import com.example.darooyab.model.Pharmacy

class PharmaciesAdapter(val pharmaciesResultList: MutableList<Pharmacy>) : RecyclerView.Adapter<PharmaciesAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: PharmaciesRecyclerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(PharmaciesRecyclerLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))





    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pharmacy = pharmaciesResultList[position]
        holder.binding.nameTextView.text = "داروخانه " +pharmacy.name
        holder.binding.phoneTextView.text = "تلفن: " +pharmacy.phone
        holder.binding.addressTextView.text = "آدرس: " + pharmacy.address
    }

    override fun getItemCount(): Int {
        return  pharmaciesResultList.size
    }


}