package com.example.iroom.model.repository

import com.example.iroom.model.entity.Apartment
import com.example.iroom.model.entity.ApartmentDetail
import com.example.iroom.model.entity.Feedback

interface ApartmentRepo {
    suspend fun fetchApartments(): List<Apartment>

    suspend fun fetchApartmentDetail(apartmentID:String): ApartmentDetail

    suspend fun fetchSuggestionApartments(apartmentID:String): List<Apartment>

    suspend fun searchApartmentByKeyword(keyword:String): List<Apartment>

    suspend fun fetchCollectionApartments(): List<Apartment>

    suspend fun fetchFeedbacks(apartmentID: String): List<Feedback>
}