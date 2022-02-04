package com.example.iroom.viewmodel.authen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.IRoomApplication
import com.example.iroom.model.entity.User
import com.example.iroom.model.entity.register.UserRole
import com.example.iroom.model.repository.AuthRepo
import com.example.iroom.utils.Const
import com.example.iroom.utils.Event
import com.example.iroom.utils.Extension.Companion.validateEmail
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authRepo: AuthRepo
) : BaseViewModel() {
    private val _userInfo: MutableLiveData<Resource<User>> = MutableLiveData()
    val userInfo: LiveData<Resource<User>> = _userInfo

    /* true -> host
       false -> user
     */
    private val _userRole : MutableLiveData<Boolean> = MutableLiveData(false)
    val userRole : LiveData<Boolean> = _userRole

    fun login(email: String, password: String) = viewModelScope.launch {
        _userInfo.postValue(Resource.Loading())
        try {
            if (validateEmail(email)) {
                if (true /* check internet*/) {
                    val response = authRepo.login(email, password)
                    _userInfo.postValue(response)
                } else {
                    _userInfo.postValue(Resource.Error("No internet"))
                }
            } else {
                throw IllegalArgumentException("Email is invalid")
            }

        } catch (t: Throwable) {
            when (t) {
                is IOException -> _userInfo.postValue(Resource.Error("Network Failure"))
                is IllegalArgumentException -> _userInfo.postValue(Resource.Error(t.message.toString()))
                else -> _userInfo.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    fun switchRole(){
        val value = !userRole.value!!
        _userRole.postValue(value)
    }
}