package com.example.iroom.model.entity

data class FeedbackReqDTO(
    val image: String?,
    val message: String?,
    val ratingStar: Int?,
    val roomId: String?,
    val type: String?
)