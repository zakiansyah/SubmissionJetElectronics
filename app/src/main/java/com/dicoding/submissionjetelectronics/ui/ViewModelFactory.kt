package com.dicoding.submissionjetelectronics.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.submissionjetelectronics.data.ElectronicsRepository
import com.dicoding.submissionjetelectronics.screen.cart.CartViewModel
import com.dicoding.submissionjetelectronics.screen.detail.DetailElectronicsViewModel
import com.dicoding.submissionjetelectronics.screen.home.HomeViewModel

class ViewModelFactory(private val repository: ElectronicsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailElectronicsViewModel::class.java)) {
            return DetailElectronicsViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}