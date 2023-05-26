package com.example.customviewaplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.data.main.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository = MainRepository()) : ViewModel() {
    private val _unitiesList: MutableLiveData<List<CondoUnit>> = MutableLiveData()
    val unitiesList: LiveData<List<CondoUnit>> = _unitiesList

    init {
        fetchData()
    }

    fun onQueryChanged(query: String) {
        if (query.isEmpty()) {
            fetchData()
        }
        _unitiesList.value = _unitiesList.value?.filter { unit -> unit.unitName.contains(query)}
    }

    private fun fetchData() {
        viewModelScope.launch {
            val data = mainRepository.getUnities()
            if (data.isSuccess) {
                _unitiesList.postValue(data.getOrDefault(listOf()))
            } else {
                println("An error has occurred, trying to recover")
            }
        }
    }

}