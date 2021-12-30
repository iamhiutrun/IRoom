package com.example.iroom.viewmodel.collection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.repository.ApartmentRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class CollectionViewModel @Inject constructor(
    private val apartmentRepo: ApartmentRepo,
) : BaseViewModel() {

    init {
        fetchCollectionApartment()
    }

    private var _apartments: MutableLiveData<Resource<List<Apartment>>> = MutableLiveData()
    var apartments: LiveData<Resource<List<Apartment>>> = _apartments

    private fun fetchCollectionApartment() = viewModelScope.launch {
        try {
            val data = apartmentRepo.fetchCollectionApartments()
            _apartments.postValue(Resource.Success(data))
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _apartments.postValue(Resource.Error("Network Failure"))
                else -> _apartments.postValue(Resource.Error("Conversion Error"))
            }
        }
    }
}