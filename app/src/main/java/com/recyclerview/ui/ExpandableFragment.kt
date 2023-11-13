package com.recyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.recyclerview.adapter.ExpandableAdapter
import com.recyclerview.common.Utility
import com.recyclerview.databinding.FragmentExpandableBinding

class ExpandableFragment : Fragment() {

    private lateinit var binding: FragmentExpandableBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpandableBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvItems.adapter = ExpandableAdapter(Utility.getPerSonList())
    }
}