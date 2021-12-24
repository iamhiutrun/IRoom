package com.example.iroom.viewmodel.authen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.User
import com.example.iroom.model.repository.AuthenRepo
import com.example.iroom.utils.Const
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val authenRepo: AuthenRepo
) : BaseViewModel() {
    private val _userInfo : MutableLiveData<Resource<User>> = MutableLiveData()
    val userInfo : LiveData<Resource<User>> = _userInfo

    fun login(email:String,password:String) = viewModelScope.launch{
        _userInfo.postValue(Resource.Loading())
        try {
            if(true /* check internet*/){
                val response = authenRepo.login(email, password)
                _userInfo.postValue(response)
            }else{
                _userInfo.postValue(Resource.Error("No internet"))
            }
        }catch (t:Throwable){
            when(t){
                is IOException -> _userInfo.postValue(Resource.Error("Network Failure"))
                else -> _userInfo.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    fun validateEmail(email:String):Boolean{
        val regex = Regex.fromLiteral(Const.EMAIL_PATTERN)
        return email.matches(regex)
    }


}