package com.dicoding.submissionjetelectronics.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.submissionjetelectronics.data.ElectronicsRepository
import com.dicoding.submissionjetelectronics.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: ElectronicsRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderElectronics() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderElectronics()
                .collect { orderElectronics ->
                    val totalPrice =
                        orderElectronics.sumOf { it.electronics.price * it.count }
                    _uiState.value = UiState.Success(CartState(orderElectronics, totalPrice))
                }
        }
    }

    fun updateOrderElectronics(electronicsId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateOrderElectronics(electronicsId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderElectronics()
                    }
                }
        }
    }
}