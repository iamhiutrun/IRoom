package com.example.iroom.model.repository

import com.example.iroom.model.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OrderRepoImpl @Inject constructor(): OrderRepo {
    override suspend fun fetchOrders(): List<Order> {
        val orders = withContext(Dispatchers.IO) {
            listOf<Order>(
                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/07/2021",
                    checkout = "30/07/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.COMPLETED, month = 1
                ),
                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/07/2021",
                    checkout = "30/07/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.WAITING, month = 2
                ),
                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/07/2021",
                    checkout = "30/07/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.COMPLETED, month = 1
                ),
                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/07/2021",
                    checkout = "30/07/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.COMPLETED, month = 1
                ),
                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/07/2021",
                    checkout = "30/07/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.COMPLETED, month = 1
                ),
                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/08/2021",
                    checkout = "30/08/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.COMPLETED, month = 1
                ),

                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/08/2021",
                    checkout = "30/08/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.COMPLETED, month = 1
                ),

                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/08/2021",
                    checkout = "30/08/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.WAITING, month = 2
                ),

                Order(
                    apartmentId = "123",
                    description = "Căn hộ cao cấp có ban công rộng 60m2",
                    apartmentUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg",
                    price = "850 000 đ",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    apartmentType = "Service Apartment",
                    checkIn = "17/08/2021",
                    checkout = "30/08/2021",
                    orderId = "OrderID:#3555555",
                    status = Status.COMPLETED, month = 1
                ),
            )
        }
        return orders
    }
}