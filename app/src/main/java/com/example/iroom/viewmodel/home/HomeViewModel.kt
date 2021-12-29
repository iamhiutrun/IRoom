package com.example.iroom.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.City
import com.example.iroom.model.repository.CityRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val cityRepo: CityRepo
) : BaseViewModel() {

    init {
        fetchCities()
    }

    private var _cities: MutableLiveData<Resource<List<City>>> = MutableLiveData()
    var cities: LiveData<Resource<List<City>>> = _cities


    private fun fetchCities() = viewModelScope.launch {
//        _cities.postValue(Resource.Loading())
        try {
            val data = cityRepo.fetchCities()
            _cities.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _cities.postValue(Resource.Error(message = e.message.toString()))
        }
    }
}