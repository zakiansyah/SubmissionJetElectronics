package com.dicoding.submissionjetelectronics.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.submissionjetelectronics.data.ElectronicsRepository
import com.dicoding.submissionjetelectronics.model.OrderElectronics
import com.dicoding.submissionjetelectronics.model.Electronics
import com.dicoding.submissionjetelectronics.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class DetailElectronicsViewModel(
    private val repository: ElectronicsRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderElectronics>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderElectronics>>
        get() = _uiState

    fun getRewardById(electronicsId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderElectronicsById(electronicsId))
        }
    }

    fun addToCart(reward: Electronics, count: Int) {
        viewModelScope.launch {
            repository.updateOrderElectronics(reward.id, count)
        }
    }
}