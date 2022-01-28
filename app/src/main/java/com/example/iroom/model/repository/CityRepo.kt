package com.example.iroom.model.repository

import com.example.iroom.model.entity.City
import com.example.iroom.model.entity.city.VietnamCity
import kotlinx.coroutines.Job

interface CityRepo {
    suspend fun fetchCities(): List<City>

    fun readCityFromJsonAsync():Job
}