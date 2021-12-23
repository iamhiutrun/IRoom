package com.example.iroom.model.repository

import com.example.iroom.model.entity.RegisterInfo
import com.example.iroom.model.entity.User
import com.example.iroom.utils.Resource

interface AuthenRepo {

    suspend fun login(email:String,password:String) : Resource<User>

    suspend fun verifyEmail(email:String)

    suspend fun register(registerInfo: RegisterInfo)
}