package com.example.iroom.viewmodel.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.iroom.IRoomApplication
import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.entity.city.District
import com.example.iroom.model.entity.city.VietnamCity
import com.example.iroom.model.entity.city.VietnamCityItem
import com.example.iroom.model.repository.ApartmentRepo
import com.example.iroom.model.repository.CityRepo
import com.example.iroom.model.repository.CityRepoImpl
import com.example.iroom.utils.CityProvider
import com.example.iroom.utils.Extension
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val apartmentRepo: ApartmentRepo,
    private val application: IRoomApplication
) : BaseViewModel() {

    private var _apartments: MutableLiveData<Resource<List<Apartment>>> = MutableLiveData()
    var apartments: LiveData<Resource<List<Apartment>>> = _apartments

    var filters = mutableListOf<Any>()

    private var _currentCity: MutableLiveData<VietnamCityItem> = MutableLiveData()
    var currentCity: LiveData<VietnamCityItem> = _currentCity

    private var _cities: MutableLiveData<VietnamCity> = MutableLiveData(CityProvider.cities)
    var cities: LiveData<VietnamCity> = _cities

    var wards: LiveData<List<District>> = Transformations.map(_currentCity) {
        _currentCity.value?.districts
    }

    private var _filterCount: MutableLiveData<Int> = MutableLiveData(0)
    var filterCount: LiveData<Int> = _filterCount

    fun searchApartmentByKeyword(keyword: String) = viewModelScope.launch {
//        _cities.postValue(Resource.Loading())
        try {
            val data = apartmentRepo.searchApartmentByKeyword(keyword)
            _apartments.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _apartments.postValue(Resource.Error(message = e.message.toString()))
        }
    }

    fun addFilters(filters: List<Any>) {
        this.filters = mutableListOf()
        this.filters.addAll(filters)
        _filterCount.postValue(filters.size)
    }

    fun setCurrentCity(city: VietnamCityItem) {
        _currentCity.postValue(city)
    }
}