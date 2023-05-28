package com.example.customviewaplication.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.data.main.MainRepository
import kotlinx.coroutines.launch
import java.lang.Exception

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
            try{
                _unitiesList.postValue(data.getOrDefault(listOf()))
            } catch(e: Exception) {
                println(e.message)
            }
        }
    }

}