package com.example.iroom.model.entity

import java.util.*

data class Feedback(
    val avatar : String,
    val fullName : String,
    val time : String,
    val comment : String,
    val rate : Float
)
