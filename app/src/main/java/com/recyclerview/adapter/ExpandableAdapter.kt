package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.common.Utility
import com.recyclerview.databinding.ExpandableItemBinding
import com.recyclerview.model.Person

class ExpandableAdapter(private val data: ArrayList<Person>) :
    RecyclerView.Adapter<ExpandableAdapter.ExpandableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableViewHolder =
        ExpandableViewHolder(
            ExpandableItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ExpandableViewHolder, position: Int) =
        holder.bind(data[position])

    inner class ExpandableViewHolder(private val binding: ExpandableItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Person) {
            binding.tvName.text = model.name
            binding.rvSubItems.adapter = ExpandableSubAdapter(Utility.getPerSonList())
            if (model.isOpen) {
                binding.rvSubItems.visibility = View.VISIBLE
            } else {
                binding.rvSubItems.visibility = View.GONE
            }
            binding.tvName.setOnClickListener {
                data[adapterPosition].isOpen = !data[adapterPosition].isOpen
                notifyItemChanged(adapterPosition, data[adapterPosition])
            }
        }
    }
}