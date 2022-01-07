package com.example.iroom.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.entity.ApartmentDetail
import com.example.iroom.model.entity.Feedback
import com.example.iroom.model.repository.ApartmentRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApartmentViewModel @Inject constructor(
    private val apartmentRepo: ApartmentRepo,
) : BaseViewModel() {

    private var _apartmentDetail: MutableLiveData<Resource<ApartmentDetail>> = MutableLiveData()
    var apartmentDetail: LiveData<Resource<ApartmentDetail>> = _apartmentDetail

    private var _suggestionApartments: MutableLiveData<Resource<List<Apartment>>> = MutableLiveData()
    var suggestionApartments: LiveData<Resource<List<Apartment>>> = _suggestionApartments

    private var _feedbacks: MutableLiveData<Resource<List<Feedback>>> = MutableLiveData()
    var feedbacks: LiveData<Resource<List<Feedback>>> = _feedbacks

     fun fetchApartmentDetail(apartmentID : String) = viewModelScope.launch {
        try {
            val data = apartmentRepo.fetchApartmentDetail(apartmentID)
            _apartmentDetail.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _apartmentDetail.postValue(Resource.Error(message = e.message.toString()))
        }
    }

     fun fetchSuggestionApartments(apartmentID : String) = viewModelScope.launch {
        try {
            val data = apartmentRepo.fetchSuggestionApartments(apartmentID)
            _suggestionApartments.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _suggestionApartments.postValue(Resource.Error(message = e.message.toString()))
        }
    }

     fun fetchFeedbacks(apartmentID : String) = viewModelScope.launch {
        try {
            val data = apartmentRepo.fetchFeedbacks(apartmentID)
            _feedbacks.postValue(Resource.Success(data))
        } catch (e: Exception) {
            _feedbacks.postValue(Resource.Error(message = e.message.toString()))
        }
    }
}