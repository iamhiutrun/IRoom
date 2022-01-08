package com.example.iroom.viewmodel.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Payment
import com.example.iroom.model.repository.OrderRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PaymentViewModel @Inject constructor(
    private val orderRepo: OrderRepo,
) : BaseViewModel() {

    private var _payment: MutableLiveData<Resource<Payment>> = MutableLiveData()
    var payment: LiveData<Resource<Payment>> = _payment

    fun fetchOrders(orderId:String) = viewModelScope.launch {
        try {
            val data = orderRepo.fetchPayment(orderId)
            _payment.postValue(Resource.Success(data))
        } catch (e: Exception) {
//            _orders.postValue(Resource.Error(message = "error"))
        }
    }

}