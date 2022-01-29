package com.example.iroom.viewmodel.authen

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.Gender
import com.example.iroom.model.entity.User
import com.example.iroom.model.entity.register.LoginReqDTO
import com.example.iroom.model.entity.register.SignUpReqDTO
import com.example.iroom.model.repository.AuthRepo
import com.example.iroom.model.repository.FirebaseListener
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    val authRepo: AuthRepo
) : BaseViewModel(), FirebaseListener {

    init {
        authRepo.setFirebaseListener(this)
    }
    private val _userInfo: MutableLiveData<Resource<User>> = MutableLiveData()
    val userInfo: LiveData<Resource<User>> = _userInfo

    private val _senOtp: MutableLiveData<Resource<User>> = MutableLiveData()
    val senOtp: LiveData<Resource<User>> = _senOtp

    fun sendOtpToEmail(phoneNumber: String, activity: FragmentActivity) = viewModelScope.launch {
        _senOtp.postValue(Resource.Loading())
        try {
            authRepo.startPhoneNumberVerification(phoneNumber, activity, ::handleException)
            _senOtp.postValue(Resource.Success(data =  User(
                id = "123",
                fullName = "Nguyễn Huy Hoàn",
                phoneNumber = "0329333964",
                birthday = "28/02/2000",
                address = "24/2/33 Ngoc Truc, Dai Mo, Nam Tu Liem, Ha Noi",
                gender = Gender.Male,
                password = "123",
                email = "Abc@gmail.com"
            )))
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _userInfo.postValue(Resource.Error("Network Failure"))
                else -> _userInfo.postValue(Resource.Error(t.message.toString()))
            }
        }
    }

    fun verifyPhoneNumberWithCode(code: String) = viewModelScope.launch {
        authRepo.verifyPhoneNumberWithCode(code)
    }

    private fun handleException(message: String) {
        Log.d("LoginViewModel", "handleException: $message")
        _userInfo.postValue(Resource.Error(message))
    }

    fun register(userInfo:User) = viewModelScope.launch {
        _userInfo.postValue(Resource.Loading())
        try {
            authRepo.register(userInfo)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _userInfo.postValue(Resource.Error("Network Failure"))
                else -> _userInfo.postValue(Resource.Error(t.message.toString()))
            }
        }
    }

    override fun onReceivedVerifyTokenSuccess(verifyToken: String)= viewModelScope.launch {
//        TODO("Not yet implemented")
        Log.e("TAG", "onReceivedVerifyTokenSuccess: $verifyToken", )
        authRepo.getFCMToken(verifyToken)
    }

    override fun onReceivedFCMSuccess(loginReqDTO: LoginReqDTO): Job {
        TODO("Not yet implemented")
    }

    override fun onFailure(e: Throwable) {
//        TODO("Not yet implemented")
    }
}