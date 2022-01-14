package com.example.iroom.model.repository

import com.example.iroom.model.entity.Notification
import com.example.iroom.model.entity.Order
import com.example.iroom.model.entity.Payment

interface NotificationRepo {
    suspend fun fetchNotifications(): List<Notification>
}