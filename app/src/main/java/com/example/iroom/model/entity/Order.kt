package com.example.iroom.model.entity

data class Order(
    val month : Int,
    val apartmentId: String,
    val orderId: String,
    val description: String,
    val apartmentUrl: String,
    val address: String,
    val apartmentType: String,
    val price: String,
    val checkIn: String,
    val checkout: String,
    val status: Status,

)