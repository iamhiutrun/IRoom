package com.example.iroom.model.repository

import com.example.iroom.model.entity.Apartment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApartmentRepoIml @Inject constructor() : ApartmentRepo {
    override suspend fun fetchApartments(): List<Apartment> {
        val apartments = withContext(Dispatchers.IO) {
            listOf<Apartment>(
                Apartment(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    guest = 3,
                    bedroom = 2,
                    bath = 1,
                    apartmentUrl = "https://bitly.com.vn/6a6my8",
                    price = "850.000 đ"
                ),
                Apartment(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    guest = 3,
                    bedroom = 2,
                    bath = 1,
                    apartmentUrl = "https://bitly.com.vn/6a6my8",
                    price = "850.000 đ"
                ),
                Apartment(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    guest = 3,
                    bedroom = 2,
                    bath = 1,
                    apartmentUrl = "https://bitly.com.vn/6a6my8",
                    price = "850.000 đ"
                ),
                Apartment(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    guest = 3,
                    bedroom = 2,
                    bath = 1,
                    apartmentUrl = "https://bitly.com.vn/6a6my8",
                    price = "850.000 đ"
                ),
                Apartment(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    guest = 3,
                    bedroom = 2,
                    bath = 1,
                    apartmentUrl = "https://bitly.com.vn/6a6my8",
                    price = "850.000 đ"
                ),
                Apartment(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    guest = 3,
                    bedroom = 2,
                    bath = 1,
                    apartmentUrl = "https://bitly.com.vn/6a6my8",
                    price = "850.000 đ"
                ),
                Apartment(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    guest = 3,
                    bedroom = 2,
                    bath = 1,
                    apartmentUrl = "https://bitly.com.vn/6a6my8",
                    price = "850.000 đ"
                ),
            )
        }
        return apartments
    }
}