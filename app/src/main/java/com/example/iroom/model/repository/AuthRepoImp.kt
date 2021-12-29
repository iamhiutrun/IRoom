package com.example.iroom.model.repository

import com.example.iroom.model.entity.RegisterInfo
import com.example.iroom.model.entity.User
import com.example.iroom.utils.Resource
import javax.inject.Inject

class AuthRepoImp @Inject constructor() : AuthenRepo {
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