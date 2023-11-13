package com.recyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.ExpandableSubItemBinding
import com.recyclerview.model.Person

class ExpandableSubAdapter(private val data: ArrayList<Person>) :
    RecyclerView.Adapter<ExpandableSubAdapter.ExpandableSubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableSubViewHolder =
        ExpandableSubViewHolder(
            ExpandableSubItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ExpandableSubViewHolder, position: Int) =
        holder.bind(data[position])

    inner class ExpandableSubViewHolder(private val binding: ExpandableSubItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Person) {
            binding.apply {
                Log.i("ExpandableSub: ", model.name)
                tvSubName.text = model.name
            }
        }
    }
}