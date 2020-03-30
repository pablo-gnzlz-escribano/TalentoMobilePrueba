package com.cryzastaylo.talentomobileprueba.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cryzastaylo.talentomobileprueba.R
import com.cryzastaylo.talentomobileprueba.ViewModel
import com.cryzastaylo.talentomobileprueba.utils.Adapter

class CompleteListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.all_list_fragment, container, false)

        val model = activity?.run {
            ViewModelProvider(this)[ViewModel::class.java]
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_complete_list)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = model?.completeList?.let { Adapter(it) }
        }
        return view
    }
}