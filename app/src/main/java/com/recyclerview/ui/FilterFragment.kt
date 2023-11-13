package com.recyclerview.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.recyclerview.adapter.FilterAdapter
import com.recyclerview.common.Utility.getPerSonList
import com.recyclerview.databinding.FragmentFilterBinding
import com.recyclerview.model.Person

class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding
    private var filterAdapter: FilterAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterAdapter = FilterAdapter(getPerSonList())
        binding.rvItems.adapter = filterAdapter

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                s?.let { text ->
                    val tempList = ArrayList<Person>()
                    for (item in getPerSonList()) {
                        if (item.name.contains(
                                text.toString(),
                                true
                            ) || item.emailId.contains(text.toString(), true)
                        )
                            tempList.add(item)
                    }
                    if (tempList.isNotEmpty()) {
                        binding.rvItems.visibility = View.VISIBLE
                        binding.tvSearchError.visibility = View.GONE

                        filterAdapter?.updateData(tempList)
                    } else {
                        binding.rvItems.visibility = View.GONE
                        binding.tvSearchError.visibility = View.VISIBLE
                    }

                }
            }

        })
    }

}