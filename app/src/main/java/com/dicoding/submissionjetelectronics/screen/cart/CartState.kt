package com.dicoding.submissionjetelectronics.screen.cart

import com.dicoding.submissionjetelectronics.model.OrderElectronics

data class CartState(
    val orderElectronics: List<OrderElectronics>,
    val totalPrice: Int
)