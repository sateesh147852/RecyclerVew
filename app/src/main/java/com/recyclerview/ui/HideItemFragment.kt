package com.recyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.recyclerview.adapter.HideItemAdapter
import com.recyclerview.common.Utility
import com.recyclerview.databinding.FragmentHideItemBinding

class HideItemFragment : Fragment() {

    private lateinit var binding: FragmentHideItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHideItemBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvItems.adapter = HideItemAdapter(Utility.getPerSonList())
    }
}