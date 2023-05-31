package com.example.customviewaplication.ui.details

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.customviewaplication.R
import com.example.customviewaplication.data.details.UnitDetailsViewModelFactory
import com.example.customviewaplication.ui.list.adapter.ResidentsAdapter

class UnitDetailsActivity : AppCompatActivity() {

    companion object {
        const val ARG_UNIT_ID = "unitId"
    }

    private var toolbar: Toolbar? = null
    private var unitPicture: ImageView? = null

    private var unitDetailsViewModel: UnitDetailsViewModel? = null
    private var errorView: ConstraintLayout? = null
    private var loadingView: ConstraintLayout? = null

    private var residentsRecyclerView: RecyclerView? = null
    private var residentsList: ResidentsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_details_main)

        toolbar = findViewById(R.id.toolbar)
        unitPicture = findViewById(R.id.unitPicture)

        residentsRecyclerView = findViewById(R.id.residentslist)

        errorView = findViewById(R.id.errorView)
        loadingView = findViewById(R.id.loadingView)

        setupViews()
        instantiateViewModel()
        setupBindings()


    }

    private fun setupViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar?.setNavigationOnClickListener {
            finish()
        }
    }


    private fun instantiateViewModel() {
        val unitId = intent.getStringExtra(ARG_UNIT_ID)
        unitId?.let {
            val viewModelFactory = UnitDetailsViewModelFactory(it)
            //passando o contexto e fazendo e o get com o class.java
            unitDetailsViewModel =
                ViewModelProvider(this, viewModelFactory)[UnitDetailsViewModel::class.java]
            unitDetailsViewModel?.fetchUnitData()

        }
    }

    private fun setupBindings() {
        unitDetailsViewModel?.uiState?.observe(this) { uiState ->
            when (uiState) {
                is MainUiState.Loading -> {
                    loadingView?.isVisible = false
                    errorView?.isVisible = false
                }

                is MainUiState.Error -> {
                    loadingView?.isVisible = false
                    errorView?.isVisible = true
                }

                is MainUiState.Success -> {
                    val unit = uiState.unities
                    residentsRecyclerView?.layoutManager =
                        GridLayoutManager(this, getSpanCount(residentsList?.itemCount))
                    residentsList = ResidentsAdapter()
                    residentsRecyclerView?.adapter = residentsList
                    unit?.residents?.let { residentsList?.setResidents(it) }

                    toolbar?.title = unit?.unitName
                    unitPicture?.load(unit?.unitPicture)
                }
            }
        }

    }

    private fun getSpanCount(residentCount: Int?): Int {
        return if (residentCount == 1) {
            1 // When there's only one resident, use a single column
        } else {
            2 // When there are two residents, use two columns
        }
    }


}