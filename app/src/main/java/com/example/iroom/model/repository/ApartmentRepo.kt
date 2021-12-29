package com.example.iroom.model.repository

import com.example.iroom.model.entity.Apartment

interface ApartmentRepo {
    suspend fun fetchApartments(): List<Apartment>

    suspend fun searchApartmentByKeyword(keyword:String): List<Apartment>

    suspend fun fetchCollectionApartments(): List<Apartment>
}