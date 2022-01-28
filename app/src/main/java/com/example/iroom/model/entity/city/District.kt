package com.example.iroom.model.entity.city

data class District(
    val code: String,
    val name: String,
    val wards: List<Ward>
)