package com.recyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.recyclerview.adapter.ListDataAdapter
import com.recyclerview.common.Utility.getPerSonList
import com.recyclerview.databinding.FragmentListAdapterBinding
import com.recyclerview.model.Person

class ListAdapterFragment : Fragment() {

    private lateinit var binding: FragmentListAdapterBinding
    private var adapter: ListDataAdapter = ListDataAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListAdapterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(getPerSonList())
        binding.rvItems.adapter = adapter

        binding.btUpdate.setOnClickListener {
            adapter.submitList(getUpdatedPerSonList())
        }
    }

    private fun getUpdatedPerSonList(): ArrayList<Person>{
        val list = ArrayList<Person>()
        list.add(Person("Sateesh",100,"abc@gmail.com"))
        list.add(Person("Ramesh",101,"def@gmail.com"))
        list.add(Person("Kiran",102,"ghi@gmail.com"))
        list.add(Person("Aadi",104,"mno@gmail.com"))
        list.add(Person("Rahul",105,"pqr@gmail.com"))
        list.add(Person("sundar",106,"stu@gmail.com"))
        list.add(Person("sundar",108,"yz@gmail.com"))
        return list
    }
}