package com.recyclerview.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.recyclerview.adapter.ViewPagerStateAdapter
import com.recyclerview.common.Utility
import com.recyclerview.databinding.FragmentDotIndicatorBinding

class DotIndicatorFragment : Fragment() {

    private lateinit var binding: FragmentDotIndicatorBinding
    private var handler: Handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable? = null
    private var endPosition = Utility.getPerSonList().size - 1
    private var currentPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDotIndicatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.adapter =
            ViewPagerStateAdapter(childFragmentManager, lifecycle, Utility.getPerSonList())

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
        }.attach()

        binding.viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                currentPosition = position
            }
        })

        startTimer()
    }

    private fun startTimer() {

        runnable = Runnable {
            binding.viewPager2.currentItem = currentPosition
            if (currentPosition == endPosition) {
                currentPosition = 0
            }
            else{
                currentPosition += +1
            }
            runnable?.let {
                handler.postDelayed(it, 2000)
            }
        }
        runnable?.let {
            handler.postDelayed(it, 2000)
        }
    }

    override fun onResume() {
        super.onResume()
        startTimer()
    }

    override fun onPause() {
        super.onPause()
        runnable?.let {
            handler.removeCallbacks(it)
        }
    }
}