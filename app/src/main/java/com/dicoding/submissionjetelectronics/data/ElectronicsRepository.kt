package com.dicoding.submissionjetelectronics.data

import com.dicoding.submissionjetelectronics.model.FakeElectronicsDataSource
import com.dicoding.submissionjetelectronics.model.OrderElectronics
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class ElectronicsRepository {

    private val orderElectronics = mutableListOf<OrderElectronics>()

    init {
        if (orderElectronics.isEmpty()) {
            FakeElectronicsDataSource.dummyElectronics.forEach {
                orderElectronics.add(OrderElectronics(it, 0))
            }
        }
    }

    fun getAllElectronics(): Flow<List<OrderElectronics>> {
        return flowOf(orderElectronics)
    }

    fun getOrderElectronicsById(electronicsId: Long): OrderElectronics {
        return orderElectronics.first {
            it.electronics.id == electronicsId
        }
    }

    fun updateOrderElectronics(ElectronicsId: Long, newCountValue: Int): Flow<Boolean> {
        val index = orderElectronics.indexOfFirst { it.electronics.id == ElectronicsId }
        val result = if (index >= 0) {
            val orderElectronic = orderElectronics[index]
            orderElectronics[index] =
                orderElectronic.copy(electronics = orderElectronic.electronics, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }
    fun getAddedOrderElectronics(): Flow<List<OrderElectronics>> {
        return getAllElectronics()
            .map { orderElectronics ->
                orderElectronics.filter { orderElectronics ->
                    orderElectronics.count != 0
                }
            }
    }

    companion object {
        @Volatile
        private var instance: ElectronicsRepository? = null

        fun getInstance(): ElectronicsRepository =
            instance ?: synchronized(this) {
                ElectronicsRepository().apply {
                    instance = this
                }
            }
    }
}