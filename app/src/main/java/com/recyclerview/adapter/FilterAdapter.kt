package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.FilterItemBinding
import com.recyclerview.model.Person

class FilterAdapter(private var list: ArrayList<Person>) : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder = FilterViewHolder(FilterItemBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class FilterViewHolder(private val binding: FilterItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(person: Person){
            binding.apply {
                tvId.text = person.id.toString()
                tvName.text = person.name
                tvEmail.text = person.emailId
            }
        }
    }

    fun updateData(newData: ArrayList<Person>){
        this.list = newData
        notifyDataSetChanged()
    }
}