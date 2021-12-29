package com.example.iroom.model.entity

data class Apartment(
    val apartmentId: String,
    val description: String,
    val guest: Int,
    val bedroom: Int,
    val bath: Int,
    val price: String,
    val apartmentUrl: String,
    val address: String
)
