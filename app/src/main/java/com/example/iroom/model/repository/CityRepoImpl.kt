package com.example.iroom.model.repository

import android.util.Log
import com.example.iroom.IRoomApplication
import com.example.iroom.model.entity.City
import com.example.iroom.model.entity.city.VietnamCity
import com.example.iroom.utils.CityProvider
import com.example.iroom.utils.Extension
import com.google.gson.Gson
import kotlinx.coroutines.*
import javax.inject.Inject

class CityRepoImpl @Inject constructor(
    val application: IRoomApplication
) : CityRepo {

    init {
        readCityFromJsonAsync()
    }

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

    override fun readCityFromJsonAsync() = CoroutineScope(Dispatchers.IO).async {
        val jsonFileString = Extension.getJsonDataFromAsset(application, "cities.json")
        val gson = Gson()
        var cities = gson.fromJson(jsonFileString, VietnamCity::class.java)
        CityProvider.cities = cities
    }
}