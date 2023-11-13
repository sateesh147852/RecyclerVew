package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.SingleSelectionItemBinding
import com.recyclerview.model.Person

class HideItemAdapter(private val list: ArrayList<Person>) : RecyclerView.Adapter<HideItemAdapter.HideItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HideItemViewHolder = HideItemViewHolder(SingleSelectionItemBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: HideItemViewHolder, position: Int) {
        if (position == 2){
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
        }else holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class HideItemViewHolder(private val binding: SingleSelectionItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(person: Person){
            binding.apply {
                tvId.text = person.id.toString()
                tvName.text = person.name
                tvEmail.text = person.emailId
            }
        }
    }

}