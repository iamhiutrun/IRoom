package com.example.iroom.viewmodel.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.entity.City
import com.example.iroom.model.entity.Order
import com.example.iroom.model.repository.OrderRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

class OrderViewModel @Inject constructor(
    private val orderRepo: OrderRepo,
) : BaseViewModel() {

    init {
        fetchOrders()
    }

    private var _orders: MutableLiveData<Resource<List<Order>>> = MutableLiveData()
    var orders: LiveData<Resource<List<Any>>> = _orders.map {
        val itemAdapterL = mutableListOf<Any>()
        if(it.data?.isNotEmpty() == true) {
            var data = it.data
            var currentDate = data[0].checkIn
            itemAdapterL.add(currentDate)
            for (i in data) {
                if(i.checkIn == currentDate) {
                    itemAdapterL.add(i)
                } else {
                    currentDate = i.checkIn
                    itemAdapterL.add(currentDate)
                    itemAdapterL.add(i)
                }
            }
        }
        Resource.Success(data = itemAdapterL)
    }

    private fun fetchOrders() = viewModelScope.launch {
        try {
            val data = orderRepo.fetchOrders()
            _orders.postValue(Resource.Success(data))
        } catch (e: Exception) {
//            _orders.postValue(Resource.Error(message = "error"))
        }
    }

}