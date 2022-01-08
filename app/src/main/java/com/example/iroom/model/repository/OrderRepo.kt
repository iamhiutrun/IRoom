package com.example.iroom.model.repository

import com.example.iroom.model.entity.Order
import com.example.iroom.model.entity.Payment

interface OrderRepo {
    suspend fun fetchOrders(): List<Order>

    suspend fun fetchPayment(orderId:String) : Payment
}