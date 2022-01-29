package com.example.iroom.model.entity.register

data class LoginReqDTO(
    val phoneNumber: String,
    val password: String,
    var device: Device? = null,
    val verifyToken: String? = null
)