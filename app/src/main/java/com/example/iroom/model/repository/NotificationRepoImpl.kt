package com.example.iroom.model.repository

import com.example.iroom.model.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotificationRepoImpl @Inject constructor() : NotificationRepo {
    override suspend fun fetchNotifications(): List<Notification> {
        val notifications = withContext(Dispatchers.IO){
            listOf(
                Notification(
                    orderId = "123",
                    price = "850 000 đ",
                    type = NotificationType.ACCEPTED,
                    time = "1m ago",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                Notification(
                    orderId = "123",
                    price = "850 000 đ",
                    type = NotificationType.ACCEPTED,
                    time = "1m ago",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                Notification(
                    time = "1m ago",
                    type = NotificationType.PROMO,
                    description = "Căn hộ cao cấp có ban công rộng",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    interested = "New room may be you interested",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                Notification(
                    orderId = "123",
                    price = "850 000 đ",
                    type = NotificationType.ACCEPTED,
                    time = "1m ago",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                Notification(
                    orderId = "123",
                    price = "850 000 đ",
                    type = NotificationType.ACCEPTED,
                    time = "1m ago",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                Notification(
                    time = "1m ago",
                    type = NotificationType.PROMO,
                    description = "Căn hộ cao cấp có ban công rộng",
                    address = "131 Trần Phú, Hà Đông, Hà Nội",
                    interested = "New room may be you interested",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                Notification(
                    orderId = "123",
                    price = "850 000 đ",
                    type = NotificationType.ACCEPTED,
                    time = "1m ago",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
                Notification(
                    orderId = "123",
                    price = "850 000 đ",
                    type = NotificationType.ACCEPTED,
                    time = "1m ago",
                    imageUrl = "https://i.postimg.cc/Hnk7gtMp/img-20181102-193519-largejpg.jpg"
                ),
            )
        }
        return notifications
    }
}