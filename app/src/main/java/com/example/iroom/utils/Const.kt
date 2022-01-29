package com.example.iroom.utils

class Const {
    companion object {
        const val DATABASE_NAME = "iroom_db"
        const val DATABASE_VERSION = 1
        const val HTTP_TIMEOUT: Long = 20
        const val HTTP_CACHE_SIZE: Long = 10 * 1024 * 1024
        const val EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
        const val MIN_AGE_TO_JOIN_APP = -10
        const val ANDROID = "Android"
    }
}