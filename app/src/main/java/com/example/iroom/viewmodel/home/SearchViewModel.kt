package com.example.iroom.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun searchApartmentByKeyword(keyword: String) = viewModelScope.launch {
//        _cities.postValue(Resource.Loading())
        try {
            val data = apartmentRepo.searchApartmentByKeyword(keyword)
            _apartments.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _apartments.postValue(Resource.Error(message = e.message.toString()))
        }
    }
}