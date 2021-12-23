package com.example.iroom.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "birthday") var birthday : String,
    @ColumnInfo(name = "email") var email : String,
    @ColumnInfo(name = "accessToken") var accessToken : String
)