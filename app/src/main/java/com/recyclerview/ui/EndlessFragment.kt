package com.recyclerview.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.adapter.EndlessAdapter
import com.recyclerview.common.Utility
import com.recyclerview.databinding.FragmentEndlessBinding
import com.recyclerview.model.Person

class EndlessFragment : Fragment() {

    private lateinit var binding: FragmentEndlessBinding
    private var adapter: EndlessAdapter = EndlessAdapter()
    private var personList: ArrayList<Person> = Utility.getPerSonList()
    private var isLoading: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEndlessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvItems.adapter = adapter
        adapter.submitList(personList)

        binding.rvItems.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager: LinearLayoutManager =
                    recyclerView.layoutManager as LinearLayoutManager
                if (!isLoading && layoutManager.findLastVisibleItemPosition() + 2 >  layoutManager.itemCount) {
                    isLoading = true
                    binding.progressCircular.visibility = View.VISIBLE
                    loadMore()
                }
            }
        })


    }

    private fun loadMore() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.progressCircular.visibility = View.GONE
            personList.addAll(Utility.getPerSonList())
            adapter.submitList(personList)
            isLoading = false
        }, 2000)
    }
}