package com.example.iroom.model.entity

import java.util.*

data class RegisterInfo(
    var email : String,
    var firstName : String,
    var phoneNumber : String,
    var birthday : Date,
    var gender: Gender,
    var address: String,
    var password:String
)
