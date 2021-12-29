package com.example.iroom.viewmodel.authen

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.User
import com.example.iroom.model.repository.AuthenRepo
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    val authenRepo: AuthenRepo
) : BaseViewModel() {

    private val _userInfo: MutableLiveData<Resource<User>> = MutableLiveData()
    val userInfo: LiveData<Resource<User>> = _userInfo

    fun sendOtpToEmail(email: String, activity: FragmentActivity) = viewModelScope.launch {
        _userInfo.postValue(Resource.Loading())
        try {
            authenRepo.startPhoneNumberVerification(email, activity, ::handleException)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _userInfo.postValue(Resource.Error("Network Failure"))
                else -> _userInfo.postValue(Resource.Error(t.message.toString()))
            }
        }
    }

    fun verifyPhoneNumberWithCode(code: String) = viewModelScope.launch {
        authenRepo.verifyPhoneNumberWithCode(code)
    }

    fun handleException(message: String) {
        Log.d("LoginViewModel", "handleException: $message")
        _userInfo.postValue(Resource.Error(message))
    }

    fun register(userInfo:User) = viewModelScope.launch {
        _userInfo.postValue(Resource.Loading())
        try {
            authenRepo.register(userInfo)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _userInfo.postValue(Resource.Error("Network Failure"))
                else -> _userInfo.postValue(Resource.Error(t.message.toString()))
            }
        }
    }
}