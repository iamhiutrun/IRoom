package com.example.iroom.model.repository

import com.example.iroom.model.entity.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityRepoImpl @Inject constructor() : CityRepo {
    override suspend fun fetchCities(): List<City> {
        val cities = withContext(Dispatchers.IO) {
            listOf<City>(
                City("Hanoi", "https://bitly.com.vn/6a6my8"),
                City("Thanh Hoa", "https://bitly.com.vn/6a6my8"),
                City("Nghe An", "https://bitly.com.vn/6a6my8"),
                City("Da Nang", "https://bitly.com.vn/6a6my8"),
                City("Da Nang", "https://bitly.com.vn/6a6my8"),
                City("Da Nang", "https://bitly.com.vn/6a6my8"),
                City("Da Nang", "https://bitly.com.vn/6a6my8"),
                City("Da Nang", "https://bitly.com.vn/6a6my8"),
            )
        }
        return cities
    }
}