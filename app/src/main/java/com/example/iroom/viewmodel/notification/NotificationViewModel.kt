package com.example.iroom.viewmodel.notification

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.entity.City
import com.example.iroom.model.entity.Notification
import com.example.iroom.model.repository.ApartmentRepo
import com.example.iroom.model.repository.CityRepo
import com.example.iroom.model.repository.NotificationRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class NotificationViewModel @Inject constructor(
    private val notificationRepo: NotificationRepo
) : BaseViewModel() {

    init {
        fetchNotifications()
    }

    private var _notifications: MutableLiveData<Resource<List<Notification>>> = MutableLiveData()
    var notifications: LiveData<Resource<List<Notification>>> = _notifications

    private fun fetchNotifications() = viewModelScope.launch {
        try {
            val data = notificationRepo.fetchNotifications()
            _notifications.postValue(Resource.Success(data))
        } catch (e: Exception) {
//            _notifications.postValue(Resource.Error(message = e.message.toString()))
        }
    }
}