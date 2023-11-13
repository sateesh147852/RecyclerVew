package com.recyclerview.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.recyclerview.adapter.RepeatAdapter
import com.recyclerview.common.Utility
import com.recyclerview.databinding.FragmentRepeatBinding

class RepeatFragment : Fragment() {

    private lateinit var binding: FragmentRepeatBinding
    private lateinit var repeatAdapter: RepeatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepeatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repeatAdapter = RepeatAdapter(Utility.getPerSonList())
        binding.rvItems.adapter = repeatAdapter
    }
}