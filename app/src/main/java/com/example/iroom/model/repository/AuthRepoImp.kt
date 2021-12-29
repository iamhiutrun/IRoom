package com.example.iroom.model.repository

import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.iroom.IRoomApplication
import com.example.iroom.model.entity.RegisterInfo
import com.example.iroom.model.entity.User
import com.example.iroom.utils.Resource
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AuthenRepoImp @Inject constructor(
    val application: IRoomApplication
) : AuthenRepo {

    val auth = FirebaseAuth.getInstance()
    private var storedVerificationId: String? = ""
    private var resendToken: PhoneAuthProvider.ForceResendingToken?= null

    override suspend fun login(email: String, password: String): Resource<User> {
        TODO("Not yet implemented")
    }

    override suspend fun verifyEmail(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(registerInfo: RegisterInfo) {
        TODO("Not yet implemented")
    }
}