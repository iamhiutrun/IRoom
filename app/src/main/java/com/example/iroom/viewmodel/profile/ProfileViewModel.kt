package com.example.iroom.viewmodel.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.iroom.model.entity.User
import com.example.iroom.model.repository.AuthRepo
import com.example.iroom.utils.Const
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.common.BaseViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val authRepo: AuthRepo
) : BaseViewModel() {

    init {
        fetchProfile()
    }

    private val _userInfo: MutableLiveData<Resource<User>> = MutableLiveData()
    val userInfo: LiveData<Resource<User>> = _userInfo

    private fun fetchProfile() = viewModelScope.launch {
//        _userInfo.postValue(Resource.Loading())
        try {
            val userInfo = authRepo.fetchProfile()
            _userInfo.postValue(Resource.Success(data = userInfo))
        } catch (t: Throwable) {
            when (t) {
//                is IOException -> _userInfo.postValue(Resource.Error("Network Failure"))
//                else -> _userInfo.postValue(Resource.Error("Conversion Error"))
            }
        }
    }
}