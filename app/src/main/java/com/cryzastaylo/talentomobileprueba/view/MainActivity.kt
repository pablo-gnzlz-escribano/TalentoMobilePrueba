package com.cryzastaylo.talentomobileprueba.view

import android.content.ContextWrapper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.cryzastaylo.talentomobileprueba.R
import com.cryzastaylo.talentomobileprueba.ViewModel
import com.cryzastaylo.talentomobileprueba.utils.AdapterViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainActivity : AppCompatActivity() {
    var viewModel: ViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        val contextWrapper: ContextWrapper = applicationContext as ContextWrapper
        viewModel?.getData(contextWrapper)

        val tabLayout: TabLayout = findViewById(R.id.tabs)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        val adapViewPager =
            AdapterViewPager(
                supportFragmentManager,
                tabLayout.tabCount
            )

        viewPager.adapter = adapViewPager
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                viewPager.currentItem = position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}