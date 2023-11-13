package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.SingleSelectionItemBinding
import com.recyclerview.model.Person

class RepeatAdapter(private val data: ArrayList<Person>) :
    RecyclerView.Adapter<RepeatAdapter.RepeatViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepeatViewHolder =
        RepeatViewHolder(
            SingleSelectionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun onBindViewHolder(holder: RepeatViewHolder, position: Int) {
        holder.bind(data[position % data.size])
    }

    inner class RepeatViewHolder(private val binding: SingleSelectionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            binding.apply {
                tvId.text = person.id.toString()
                tvName.text = person.name
                tvEmail.text = person.emailId
            }
        }
    }
}