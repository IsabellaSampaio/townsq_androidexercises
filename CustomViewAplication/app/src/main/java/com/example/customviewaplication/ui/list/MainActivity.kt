package com.example.customviewaplication.ui.list

import com.example.customviewaplication.ui.details.UnitDetailsActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewaplication.R
import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.ui.components.SearchBarView
import com.example.customviewaplication.ui.list.adapter.UnitiesAdapter

class MainActivity: AppCompatActivity() {
    private var searchBar: SearchBarView? = null
    private var unitiesRecyclerView: RecyclerView? = null
    private var unitiesAdapter: UnitiesAdapter? = null

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBar = findViewById(R.id.searchBar)
        unitiesRecyclerView = findViewById(R.id.unitiesList)
        setupViews()
        setupBindings()
    }

    private fun setupViews() {
        searchBar?.newInstance { newQuery ->
            mainViewModel.onQueryChanged(newQuery)
        }
    }

    private fun setupBindings() {
        mainViewModel.unitiesList.observe(this) { unities ->
            setupAdapter(unities)
        }
    }

    private fun setupAdapter(unitiesList: List<CondoUnit>) {
        unitiesAdapter = UnitiesAdapter { unitId ->
            val intent = Intent(this, UnitDetailsActivity::class.java)
            intent.putExtra(UnitDetailsActivity.ARG_UNIT_ID, unitId)
            startActivity(intent)
        }
        unitiesRecyclerView?.adapter = unitiesAdapter
        unitiesAdapter?.setUnities(unitiesList)
    }

}