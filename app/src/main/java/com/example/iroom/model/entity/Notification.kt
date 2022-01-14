package com.example.iroom.model.entity

data class Notification(
    val orderId:String?=null,
    val price:String?=null,
    val type:NotificationType?=null,
    val interested:String?=null,
    val description:String?=null,
    val address:String?=null,
    val time:String,
    val imageUrl:String
)
