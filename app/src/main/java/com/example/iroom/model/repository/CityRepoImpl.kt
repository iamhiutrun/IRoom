package com.example.iroom.model.repository

import com.example.iroom.model.entity.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityRepoImpl @Inject constructor() : CityRepo {
    override suspend fun fetchCities(): List<City> {
        val cities = withContext(Dispatchers.IO) {
            listOf<City>(
                City("Hanoi", "https://i.postimg.cc/xdm8D4FG/city1.png"),
                City("Thanh Hoa", "https://i.postimg.cc/xdm8D4FG/city1.png"),
                City("Nghe An", "https://i.postimg.cc/xdm8D4FG/city1.png"),
                City("Da Nang", "https://i.postimg.cc/xdm8D4FG/city1.png"),
                City("Da Nang", "https://i.postimg.cc/xdm8D4FG/city1.png"),
                City("Da Nang", "https://i.postimg.cc/xdm8D4FG/city1.png"),
                City("Da Nang", "https://i.postimg.cc/xdm8D4FG/city1.png"),
                City("Da Nang", "https://i.postimg.cc/xdm8D4FG/city1.png"),
            )
        }
        return cities
    }
}