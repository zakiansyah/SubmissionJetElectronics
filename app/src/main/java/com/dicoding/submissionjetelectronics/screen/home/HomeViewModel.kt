package com.dicoding.submissionjetelectronics.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.submissionjetelectronics.data.ElectronicsRepository
import com.dicoding.submissionjetelectronics.model.OrderElectronics
import com.dicoding.submissionjetelectronics.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ElectronicsRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderElectronics>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderElectronics>>>
        get() = _uiState

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllElectronics()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderElectronics ->
                    _uiState.value = UiState.Success(orderElectronics)
                }
        }
    }
}