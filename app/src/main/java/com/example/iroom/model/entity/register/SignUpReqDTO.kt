package com.example.iroom.model.entity.register

import com.example.iroom.model.entity.Gender

data class SignUpReqDTO(
    val fullName: String,
    val email: String,
    val address: String,
    val dateOfBirth: String,
    val gender: Gender,
    val userRole: UserRole,
    val verifyToken: String?=null,
    val avatar: String?=null,
    val device: Device?=null,
    val bankAccount: BankAccount?=null,
    val identityNumber: String?=null
)