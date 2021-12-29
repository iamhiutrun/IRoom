package com.example.iroom.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.entity.City
import com.example.iroom.model.repository.ApartmentRepo
import com.example.iroom.model.repository.CityRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val cityRepo: CityRepo,
    private val apartmentRepo: ApartmentRepo,
) : BaseViewModel() {

    init {
        fetchCities()
        fetchApartments()
    }

    private var _cities: MutableLiveData<Resource<List<City>>> = MutableLiveData()
    var cities: LiveData<Resource<List<City>>> = _cities

    private var _apartments: MutableLiveData<Resource<List<Apartment>>> = MutableLiveData()
    var apartments: LiveData<Resource<List<Apartment>>> = _apartments


    private fun fetchCities() = viewModelScope.launch {
//        _cities.postValue(Resource.Loading())
        try {
            val data = cityRepo.fetchCities()
            _cities.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _cities.postValue(Resource.Error(message = e.message.toString()))
        }
    }

    private fun fetchApartments() = viewModelScope.launch {
//        _cities.postValue(Resource.Loading())
        try {
            val data = apartmentRepo.fetchApartments()
            _apartments.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _apartments.postValue(Resource.Error(message = e.message.toString()))
        }
    }
}