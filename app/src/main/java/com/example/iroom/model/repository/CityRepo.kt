package com.example.iroom.model.repository

import com.example.iroom.model.entity.City

interface CityRepo {
    suspend fun fetchCities(): List<City>
}