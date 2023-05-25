package com.example.customviewaplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.ui.adapter.UnitiesAdapter
import com.example.customviewaplication.ui.components.SearchBarView
import com.example.customviewaplication.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private var searchBar: SearchBarView? = null
    private var unitiesRecyclerView: RecyclerView? = null
    private var unitiesAdapter: UnitiesAdapter = UnitiesAdapter()

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBar = findViewById(R.id.searchBar)
        unitiesRecyclerView = findViewById(R.id.unitiesList)
        setupViews()
    }

    private fun setupViews() {
        setupAdapter(mainViewModel.unitiesList.value.orEmpty())
        searchBar?.newInstance { newQuery ->
            mainViewModel.onQueryChanged(newQuery)
            setupAdapter(mainViewModel.filteredList)
        }
        observeData()
    }

    private fun observeData() {
        mainViewModel.unitiesList.observe(this) { unities ->
            setupAdapter(unities)
        }
    }

    private fun setupAdapter(unitiesList: List<CondoUnit>) {
        unitiesRecyclerView?.adapter = unitiesAdapter
        unitiesAdapter.setUnities(unitiesList)
    }


}