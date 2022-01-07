package com.example.iroom.model.repository

import com.example.iroom.model.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApartmentRepoIml @Inject constructor() : ApartmentRepo {
    private var apartments: List<Apartment> = listOf<Apartment>(
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://i.postimg.cc/4xmnwd6S/hotel-presidente-4s.jpg",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://i.postimg.cc/4xmnwd6S/hotel-presidente-4s.jpg",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://i.postimg.cc/4xmnwd6S/hotel-presidente-4s.jpg",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://i.postimg.cc/MTMpbr1f/hotel-presidente.jpg",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://i.postimg.cc/MTMpbr1f/hotel-presidente.jpg",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
    )

    override suspend fun fetchApartments(): List<Apartment> {
        val apartments = withContext(Dispatchers.IO) {
            apartments
        }
        return apartments
    }

    override suspend fun fetchApartmentDetail(apartmentID: String): ApartmentDetail {
        val apartmentDetail = withContext(Dispatchers.IO){
            ApartmentDetail(
                apartmentId = "123",
                description = "Căn hộ cao cấp có ban công rộng 60m2",
                guest = 3,
                bedroom = 2,
                bath = 1,
                apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                price = listOf<Price>(
                    Price(dayName = "Monday", "850.000 đ"),
                    Price(dayName = "Tuesday", "850.000 đ"),
                    Price(dayName = "Thursday", "850.000 đ"),
                    Price(dayName = "Friday", "850.000 đ"),
                ),
                specialPrice = listOf<Price>(
                    Price(dayName = "21/5", "850.000 đ"),
                    Price(dayName = "Halloween", "850.000 đ"),
                    Price(dayName = "17/7", "850.000 đ"),
                    Price(dayName = "20/11", "850.000 đ"),
                ),
                address = "131 Trần Phú, Hà Đông, Hà Nội",
                apartmentType = "Service Apartment",
                detail = "Bungalow tiện nghi khép kín, thích hợp cho gia đình nhỏ bé của bạn. Có nhà ếp chung cho bố mẹ chuẩn bị bữa ăn cho những thiên thần của mình",
                convenient = listOf(
                    "Air-condition",
                    "Fridge",
                    "Heat",
                    "Washing-machine",
                    "TV"
                ),
                host = Host(
                    fullName = "Lương Trung Hiếu",
                    apartmentCount = 3,
                    avatar = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                order = 20,
                policy = Policy(
                    policy = "Bungalow tiện nghi khép kín, thích hợp cho gia đình nhỏ bé của bạn. Có nhà ếp chung cho bố mẹ chuẩn bị bữa ăn cho những thiên thần của mình",
                    checkIn = "14:20",
                    checkOut = "20:05"
                ),
                rate = 4.5F,
                viewUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
            )
        }
        return apartmentDetail
    }

    override suspend fun fetchSuggestionApartments(apartmentID: String): List<Apartment> {
        val apartments = withContext(Dispatchers.IO) {
           apartments
        }
        return apartments
    }

    override suspend fun fetchFeedbacks(apartmentID: String): List<Feedback> {
        val feedbacks = withContext(Dispatchers.IO){
            listOf(
                Feedback(
                    avatar = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    rate = 4.5F,
                    comment = "That's great. I love it so much",
                    fullName = "Nguyễn Minh Quang",
                    time = "17/07/2001 17:54"
                ),
                Feedback(
                    avatar = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    rate = 4.5F,
                    comment = "That's great. I love it so much",
                    fullName = "Nguyễn Minh Quang",
                    time = "17/07/2001 17:54"
                ),
                Feedback(
                    avatar = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    rate = 4.5F,
                    comment = "That's great. I love it so much",
                    fullName = "Nguyễn Minh Quang",
                    time = "17/07/2001 17:54"
                ),
                Feedback(
                    avatar = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    rate = 4.5F,
                    comment = "That's great. I love it so much",
                    fullName = "Nguyễn Minh Quang",
                    time = "17/07/2001 17:54"
                ),
            )
        }
        return feedbacks
    }

    override suspend fun searchApartmentByKeyword(keyword: String): List<Apartment> {
        val apartments = withContext(Dispatchers.IO) {
            var list = mutableListOf<Apartment>()
            for (i in apartments) {
                if (i.apartmentId.contains(keyword)) {
                    list.add(i)
                }
            }
            list
        }
        return apartments
    }

    override suspend fun fetchCollectionApartments(): List<Apartment> {
        val apartments = withContext(Dispatchers.IO) {
            apartments
        }
        return apartments
    }
}