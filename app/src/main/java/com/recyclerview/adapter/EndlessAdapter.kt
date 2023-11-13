package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.EndlessItemBinding
import com.recyclerview.model.Person

class EndlessAdapter : ListAdapter<Person,EndlessAdapter.EndlessViewHolder>(EndlessDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EndlessViewHolder = EndlessViewHolder(EndlessItemBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: EndlessViewHolder, position: Int) = holder.bind(getItem(position))

    inner class EndlessViewHolder(private val binding: EndlessItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(person: Person){
            binding.apply {
                tvId.text = person.id.toString()
                tvName.text = person.name
                tvEmail.text = person.emailId
            }
        }
    }
}

class EndlessDiffUtilCallBack : DiffUtil.ItemCallback<Person>(){

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean = oldItem == newItem


}