package com.example.iroom.model.entity.city

data class VietnamCityItem(
    val districts: List<District>,
    val code: String,
    val name: String,
    val division_type: String,
)