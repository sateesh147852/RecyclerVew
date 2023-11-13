package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.SingleSelectionItemBinding
import com.recyclerview.model.Person

class MultiSelectionAdapter(private val list: ArrayList<Person>) :
    RecyclerView.Adapter<MultiSelectionAdapter.MultiSelectionViewHolder>() {

    private var selectedPersonList: ArrayList<Person> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiSelectionViewHolder =
        MultiSelectionViewHolder(
            SingleSelectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MultiSelectionViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    inner class MultiSelectionViewHolder(private val binding: SingleSelectionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    selectedPersonList.add(list[adapterPosition])
                } else {
                    if (selectedPersonList.contains(list[adapterPosition])) {
                        if (adapterPosition > -1 && selectedPersonList.size > adapterPosition)
                            selectedPersonList.remove(list[adapterPosition])
                    }
                }
            }
        }

        fun bind(person: Person) {
            binding.apply {
                tvId.text = person.id.toString()
                tvName.text = person.name
                tvEmail.text = person.emailId
            }
        }
    }

    fun getSelectedPersonList(): ArrayList<Person> = selectedPersonList
}