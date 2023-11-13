package com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.databinding.SingleSelectionItemBinding
import com.recyclerview.model.Person

class SingleSelectionAdapter(private val list: ArrayList<Person>) :
    RecyclerView.Adapter<SingleSelectionAdapter.SingleSelectionViewHolder>() {

    private var previousSelectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleSelectionViewHolder =
        SingleSelectionViewHolder(
            SingleSelectionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SingleSelectionViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class SingleSelectionViewHolder(private val binding: SingleSelectionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    previousSelectedPosition = adapterPosition
                } else {
                    previousSelectedPosition = -1
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

    fun getSelectedPerson(): Person? = if (previousSelectedPosition == -1) null else list[previousSelectedPosition]
}