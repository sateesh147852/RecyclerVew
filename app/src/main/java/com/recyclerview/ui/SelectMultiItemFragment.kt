package com.recyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.recyclerview.adapter.MultiSelectionAdapter
import com.recyclerview.common.Utility.getPerSonList
import com.recyclerview.databinding.FragmentSelectMultiItemBinding

class SelectMultiItemFragment : Fragment() {

    private lateinit var binding: FragmentSelectMultiItemBinding
    private var adapter: MultiSelectionAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectMultiItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MultiSelectionAdapter(getPerSonList())
        binding.rvItems.adapter = adapter
        binding.btShow.setOnClickListener {
            adapter?.let { adapter ->
                if (adapter.getSelectedPersonList().isNotEmpty()) {
                    val personNames: StringBuilder = StringBuilder()
                    for (item in adapter.getSelectedPersonList()) {
                        personNames.append(item.name + " ")
                    }
                    Toast.makeText(activity, personNames.toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Please select a person", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}