package com.example.customviewaplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.data.main.MainDataSource
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception

class MainViewModel(private val mainDataSource: MainDataSource = MainDataSource()) : ViewModel() {
    private val _unitiesList: MutableLiveData<List<CondoUnit>> = MutableLiveData()
    val unitiesList: LiveData<List<CondoUnit>> = _unitiesList
    init {
        fetchData()
    }

    fun onQueryChanged(query: String) {
        if (query.isEmpty()) {
             fetchData()
        }
        _unitiesList.value = _unitiesList.value?.filter { unit -> unit.unityName.contains(query) }.orEmpty()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = mainDataSource.getUnities()
            if (data.isSuccess) {
                _unitiesList.value = data.getOrDefault(listOf())
            } else {
                println("An error has occurred, trying to recover")
            }
        }
    }

}