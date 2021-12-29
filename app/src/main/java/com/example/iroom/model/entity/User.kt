package com.example.iroom.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey var id: String?=null,
    @ColumnInfo(name = "fullName") var fullName: String,
    @ColumnInfo(name = "phoneNumber") var phoneNumber: String,
    @ColumnInfo(name = "birthday") var birthday : String,
    @ColumnInfo(name = "gender") var gender: Gender,
    @ColumnInfo(name = "address") var address : String,
    @ColumnInfo(name = "accessToken") var accessToken : String?=null,
    @ColumnInfo(name = "password") var password : String
)