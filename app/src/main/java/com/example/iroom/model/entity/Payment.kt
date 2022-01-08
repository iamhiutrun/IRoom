package com.example.iroom.model.entity

data class Payment(
    val hostPayment: HostPayment,
    val transactionId: String,
    val price: String
)
