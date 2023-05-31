package com.example.customviewaplication.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.data.details.UnitDetailsMainRepository
import kotlinx.coroutines.launch

class UnitDetailsViewModel(
    private val unitDetailsMainRepository: UnitDetailsMainRepository = UnitDetailsMainRepository(),
    private val unitId: String
) :
    ViewModel() {

    //observables que vao observar o estado da view w agir de acordo com o lifecycle dela
    private val _uiState: MutableLiveData<MainUiState> = MutableLiveData()
    val uiState: LiveData<MainUiState> = _uiState


    //escopo da corrotina
    fun fetchUnitData() {
        viewModelScope.launch {
            emitUiState(MainUiState.Loading)
            try {
                val result = unitDetailsMainRepository.getUnit(unitId)
                emitUiState(
                    MainUiState.Success(result.getOrNull())
                )
            } catch (e: Exception) {
                println(e.message)
                emitUiState(MainUiState.Error)
            }
        }
    }

    private fun emitUiState(newUiState: MainUiState) {
        _uiState.value = newUiState
    }

}

sealed class MainUiState {
    object Error : MainUiState()
    object Loading : MainUiState()
    data class Success(val unities: CondoUnit?) : MainUiState()
}

