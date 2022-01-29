package com.example.iroom.model.repository

import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.iroom.IRoomApplication
import com.example.iroom.model.entity.Gender
import com.example.iroom.model.entity.User
import com.example.iroom.model.entity.register.Device
import com.example.iroom.model.entity.register.LoginReqDTO
import com.example.iroom.model.entity.register.SignUpReqDTO
import com.example.iroom.utils.Extension.Companion.getDeviceName
import com.example.iroom.utils.Extension.Companion.getMacAddress
import com.example.iroom.utils.Resource
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AuthRepoImp @Inject constructor(
    val application: IRoomApplication
) : AuthRepo {

    val auth = FirebaseAuth.getInstance()
    private var storedVerificationId: String? = ""
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null
    private lateinit var firebaseListener: FirebaseListener

    override suspend fun login(email: String, password: String): Resource<User> {
        TODO("Not yet implemented")
    }

    override suspend fun login(loginReqDTO: LoginReqDTO) {
        // get device info

        // get FCM token
        //
//        loginReqDTO.device = Device(
//            deviceOS = getDeviceName(),
//            macAddress = getMacAddress(application)
//        )

    }

    override suspend fun startPhoneNumberVerification(
        phoneNumber: String,
        activity: FragmentActivity,
        message: (String) -> Unit
    ) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setActivity(activity)
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    Log.d("TAG", "verify:  success")
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    message(p0.message.toString())
                    Log.d("TAG", "verify:  failed")
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    super.onCodeSent(verificationId, token)
                    storedVerificationId = verificationId
                    resendToken = token
                    Log.d("TAG", "onCodeSent: ")
                }
            })
        if (resendToken != null) {
            options.setForceResendingToken(resendToken!!) // callback's ForceResendingToken
        }
        PhoneAuthProvider.verifyPhoneNumber(options.build())
    }

    override suspend fun verifyPhoneNumberWithCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(storedVerificationId!!, code)
        auth.signInWithCredential(credential).addOnCompleteListener { authResult ->
            if (authResult.isSuccessful) {
                authResult.result?.user?.getIdToken(false)?.addOnSuccessListener { tokenResult ->
                    tokenResult.token?.let { token ->
                        firebaseListener.onReceivedVerifyTokenSuccess(token)
                        Log.e("TAG", "verifyPhoneNumberWithCode: $token")
                    }
                    Log.d("TAG", "verifyPhoneNumberWithCode: Success")
                }
            } else {
                Log.d("TAG", "verifyPhoneNumberWithCode: Failed")
                authResult.exception?.let { error ->
                    firebaseListener.onFailure(error)
                }
            }
        }
    }

    override suspend fun fetchProfile(): User {
        return withContext(Dispatchers.IO) {
            User(
                id = "123",
                fullName = "Nguyễn Huy Hoàn",
                phoneNumber = "0329333964",
                birthday = "28/02/2000",
                address = "24/2/33 Ngoc Truc, Dai Mo, Nam Tu Liem, Ha Noi",
                gender = Gender.Male,
                password = "123",
                email = "Abc@gmail.com"
            )
        }
    }

    override fun setFirebaseListener(firebaseListener: FirebaseListener) {
        this.firebaseListener = firebaseListener
    }

    override suspend fun getFCMToken(verifyToken: String) {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener {
                it.result?.let { fcmToken ->
//                    val loginReqDTO = LoginReqDTO(
//                        device = Device(it1, getDeviceName(), getMacAddress(application)),
//                        verifyToken = verifyToken
//                    )
//                    firebaseListener.onReceivedFCMSuccess(loginRequest)
                    Log.d("TAG", "getFCMToken: $fcmToken")
                }
            }.addOnFailureListener {
                firebaseListener.onFailure(it)
            }
    }


    override suspend fun register(userInfo: User) {
        TODO("Not yet implemented")
    }
}

interface FirebaseListener {
    fun onReceivedVerifyTokenSuccess(verifyToken: String): Job
    fun onReceivedFCMSuccess(loginReqDTO: LoginReqDTO): Job
    fun onFailure(e: Throwable)
}