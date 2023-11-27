package com.dicoding.submissionjetelectronics.di

import com.dicoding.submissionjetelectronics.data.ElectronicsRepository

object Injection {
    fun provideRepository(): ElectronicsRepository {
        return ElectronicsRepository.getInstance()
    }
}