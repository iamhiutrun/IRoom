package com.example.iroom.utils

class Const {
    companion object {
        const val DATABASE_NAME = "iroom_db"
        const val DATABASE_VERSION = 1
        const val HTTP_TIMEOUT: Long = 20
        const val HTTP_CACHE_SIZE: Long = 10 * 1024 * 1024
        const val EMAIL_PATTERN = "^[A-Za-z0-9]+[0-9,a-z,A-Z,_,.,-]+@[\\w.-]+.\\w{2,}\$"
        const val MIN_AGE_TO_JOIN_APP = -10
        const val ANDROID = "Android"

        const val API_LOGIN = "auth/login"
        const val API_LOGOUT = "auth/logout"
        const val API_SIGN_UP = "auth/sign_up"
        const val API_FEEDBACK = "auth/feedback"
        const val API_GET_SELF_USER = "iroom/user"
        const val API_GET_OTHER_USER = "iroom/user/{userId}"
    }
}