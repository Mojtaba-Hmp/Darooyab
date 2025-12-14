package com.example.darooyab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.darooyab.databinding.RecyclerLayoutBinding
import com.example.darooyab.model.Medicine

class MyAdapter(val resultsList: MutableList<Medicine>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))





    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.engNameTextView.text = resultsList[position].engName
        holder.binding.faNameTextView.text = resultsList[position].faName
        holder.binding.dosageTextView.text = resultsList[position].dosage
        holder.binding.typeTextView.text = resultsList[position].type
    }

    override fun getItemCount(): Int {
        return  resultsList.size
    }


}