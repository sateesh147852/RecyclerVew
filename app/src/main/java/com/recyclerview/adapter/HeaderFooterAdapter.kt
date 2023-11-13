package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.FooterItemBinding
import com.recyclerview.databinding.HeaderItemBinding
import com.recyclerview.databinding.SingleSelectionItemBinding
import com.recyclerview.model.Person

class HeaderFooterAdapter(private val list: ArrayList<Person>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val header = 0
    private val item = 1
    private val footer = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            header -> HeaderViewHolder(HeaderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            footer -> FooterViewHolder(FooterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> ItemViewHolder(SingleSelectionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            holder.bind(list[position-1])
        }
    }

    override fun getItemCount(): Int = list.size + 2

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> header
            list.size + 1 -> footer
            else -> item
        }
    }

    inner class ItemViewHolder(private val binding: SingleSelectionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            binding.apply {
                tvId.text = person.id.toString()
                tvName.text = person.name
                tvEmail.text = person.emailId
            }
        }
    }

    inner class HeaderViewHolder(binding: HeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class FooterViewHolder(binding: FooterItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}