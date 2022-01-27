package com.example.iroom.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.repository.ApartmentRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val apartmentRepo: ApartmentRepo,
) : BaseViewModel() {

    private var _apartments: MutableLiveData<Resource<List<Apartment>>> = MutableLiveData()
    var apartments: LiveData<Resource<List<Apartment>>> = _apartments

    var filters = mutableListOf<Any>()

    private var _filterCount : MutableLiveData<Int> = MutableLiveData(0)
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

    fun addFilters(filters : List<Any>){
        this.filters = mutableListOf()
        this.filters.addAll(filters)
        _filterCount.postValue(filters.size)
    }
}