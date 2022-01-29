package com.example.iroom.model.repository

import androidx.fragment.app.FragmentActivity
import com.example.iroom.model.entity.RegisterInfo
import com.example.iroom.model.entity.User
import com.example.iroom.model.entity.register.LoginReqDTO
import com.example.iroom.utils.Resource

interface AuthRepo {

    suspend fun login(email: String, password: String): Resource<User>
    suspend fun login(loginReqDTO: LoginReqDTO)

    suspend fun startPhoneNumberVerification(
        phoneNumber: String,
        activity: FragmentActivity,
        message: (String) -> Unit
    )

    suspend fun register(userInfo: User)

    suspend fun verifyPhoneNumberWithCode(code: String)

    suspend fun fetchProfile(): User

    fun setFirebaseListener(firebaseListener: FirebaseListener)

    suspend fun getFCMToken(verifyToken: String)
}