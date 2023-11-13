package com.recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recyclerview.R
import com.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            //.add(R.id.fcContainer, CardViewFragment())
            //.add(R.id.fcContainer, ListAdapterFragment())
            //.add(R.id.fcContainer, FilterFragment())
            //.add(R.id.fcContainer, SelectSingleItemFragment())
            //.add(R.id.fcContainer, SelectMultiItemFragment())
            //.add(R.id.fcContainer, HideItemFragment())
            //.add(R.id.fcContainer, HeaderFooterFragment())
            //.add(R.id.fcContainer, EndlessFragment())
            //.add(R.id.fcContainer, RepeatFragment())
            //.add(R.id.fcContainer, DotIndicatorFragment())
            .add(R.id.fcContainer, ExpandableFragment())
            .commit()
    }
}