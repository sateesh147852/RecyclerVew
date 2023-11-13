package com.recyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.recyclerview.databinding.FragmentPersonViewPagerBinding

class PersonViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentPersonViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { arguments ->
            binding.apply {
                tvId.text = arguments.getInt(ID).toString()
                tvName.text = arguments.getString(NAME)
                tvEmail.text = arguments.getString(EMAIL_ID)
            }
        }
    }

    companion object {

        private val NAME: String = "NAME"
        private val EMAIL_ID: String = "EMAIL_ID"
        private val ID: String = "ID"

        fun newInstance(name: String, emailId: String, id: Int): PersonViewPagerFragment =
            PersonViewPagerFragment().apply {
                val bundle = Bundle()
                bundle.putString(NAME, name)
                bundle.putString(EMAIL_ID, emailId)
                bundle.putInt(ID, id)
                arguments = bundle
            }

    }
}