package com.example.iroom.model.repository

import com.example.iroom.model.entity.Order

interface OrderRepo {
    suspend fun fetchOrders(): List<Order>
}