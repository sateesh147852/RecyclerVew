package com.recyclerview.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.recyclerview.model.Person
import com.recyclerview.ui.PersonViewPagerFragment

class ViewPagerStateAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val data: ArrayList<Person>
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment {
        val person = data[position]
        return PersonViewPagerFragment.newInstance(person.name, person.emailId, person.id)
    }
}