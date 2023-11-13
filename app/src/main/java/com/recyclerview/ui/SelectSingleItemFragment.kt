package com.recyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.recyclerview.adapter.SingleSelectionAdapter
import com.recyclerview.common.Utility.getPerSonList
import com.recyclerview.databinding.FragmentSelectSingleItemBinding

class SelectSingleItemFragment : Fragment(){

    private lateinit var binding: FragmentSelectSingleItemBinding
    private var adapter: SingleSelectionAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectSingleItemBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SingleSelectionAdapter(getPerSonList())
        binding.rvItems.adapter = adapter

        binding.btShow.setOnClickListener {
            adapter?.getSelectedPerson()?.let {
                Toast.makeText(activity,it.name,Toast.LENGTH_SHORT).show()
            } ?: kotlin.run {
                Toast.makeText(activity,"Please select a person",Toast.LENGTH_SHORT).show()
            }
        }
    }
}