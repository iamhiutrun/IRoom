package com.example.iroom.model.repository

import com.example.iroom.model.entity.Apartment
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
            apartmentUrl = "https://bitly.com.vn/6a6my8",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://bitly.com.vn/6a6my8",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://bitly.com.vn/6a6my8",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://bitly.com.vn/6a6my8",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://bitly.com.vn/6a6my8",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://bitly.com.vn/6a6my8",
            price = "850.000 đ",
            address = "131 Trần Phú, Hà Đông, Hà Nội"
        ),
        Apartment(
            apartmentId = "123",
            description = "Căn hộ cao cấp có ban công rộng 60m2",
            guest = 3,
            bedroom = 2,
            bath = 1,
            apartmentUrl = "https://bitly.com.vn/6a6my8",
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

    override suspend fun searchApartmentByKeyword(keyword: String): List<Apartment> {
        val apartments = withContext(Dispatchers.IO) {
            var list  = mutableListOf<Apartment>()
            for (i in apartments){
                if(i.apartmentId.contains(keyword)){
                    list.add(i)
                }
            }
            list
        }
        return apartments
    }
}