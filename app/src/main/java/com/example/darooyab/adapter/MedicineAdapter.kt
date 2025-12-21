package com.example.darooyab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.darooyab.databinding.MedicineRecyclerLayoutBinding
import com.example.darooyab.model.Medicine

class MedicineAdapter(val resultsList: MutableList<Medicine>,val onPharmacyClick: (Int) -> Unit) : RecyclerView.Adapter<MedicineAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: MedicineRecyclerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(MedicineRecyclerLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))





    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val medicine = resultsList[position]
        holder.binding.engNameTextView.text = medicine.engName
        holder.binding.faNameTextView.text = medicine.faName
        holder.binding.dosageTextView.text = medicine.dosage
        holder.binding.typeTextView.text = medicine.type

        holder.binding.pharmacyButton.setOnClickListener {
            onPharmacyClick(medicine.id)
        }
    }

    override fun getItemCount(): Int {
        return  resultsList.size
    }


}