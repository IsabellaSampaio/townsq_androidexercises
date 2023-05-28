package com.example.customviewaplication.ui.details

import android.annotation.SuppressLint
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.data.details.UnitDetailsMainRepository
import kotlinx.coroutines.launch
import java.io.IOException

class UnitDetailsViewModel(
    private val unitDetailsMainRepository: UnitDetailsMainRepository = UnitDetailsMainRepository(),
    private val unitId: String
) :
    ViewModel() {

    //observables que vao observar o estado da view w agir de acordo com o lifecycle dela
    private val _unitDetails: MutableLiveData<CondoUnit> = MutableLiveData()
    val unitDetails: LiveData<CondoUnit> = _unitDetails

    private val _error: MutableLiveData<Boolean> = MutableLiveData()
    val error: LiveData<Boolean> = _error

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading


    //escopo da corrotina
    fun fetchUnitData() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val result = unitDetailsMainRepository.getUnit(unitId)
                _unitDetails.value = result.getOrNull()
                _loading.value = false
                _error.value = false
            } catch (e: Exception) {
                println(e.message)
                _loading.value = false
                _error.value = true
            }
        }
    }



}