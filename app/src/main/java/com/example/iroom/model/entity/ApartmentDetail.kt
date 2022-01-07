package com.example.iroom.model.entity

data class ApartmentDetail(
    val apartmentId: String,
    val description: String,
    val guest: Int,
    val bedroom: Int,
    val bath: Int,
    val rate : Float,
    val order : Int,
    val apartmentUrl: String,
    val address: String,
    val detail: String,
    val apartmentType:String,
    val host:Host,
    val convenient: List<String>,
    val viewUrl : String,
    val price: List<Price>,
    val specialPrice: List<Price>,
    val policy : Policy
)
