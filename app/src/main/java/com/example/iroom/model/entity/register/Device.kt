package com.example.iroom.model.entity.register

data class Device(
    var deviceOS: String,
    val fcmToken: String,
    val macAddress: String
)