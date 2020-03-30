package com.cryzastaylo.talentomobileprueba.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cryzastaylo.talentomobileprueba.view.fragments.CompleteListFragment
import com.cryzastaylo.talentomobileprueba.view.fragments.VisibleListFragment

class AdapterViewPager internal constructor(
    fm: FragmentManager,
    private val numeroTabs: Int
) :
    FragmentPagerAdapter(fm, numeroTabs) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CompleteListFragment()
            1 -> VisibleListFragment()
            else -> CompleteListFragment()
        }
    }

    override fun getCount(): Int {
        return numeroTabs
    }

}