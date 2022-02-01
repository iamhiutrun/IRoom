package com.example.iroom.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import com.example.iroom.IRoomApplication
import java.io.IOException
import java.lang.RuntimeException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class Extension {
    companion object {
        fun encodeToSHA1(input: String): String? {
            return try {
                val md: MessageDigest = MessageDigest.getInstance("SHA-1")
                val messageDigest: ByteArray = md.digest(input.toByteArray())
                val no = BigInteger(1, messageDigest)
                var hashtext: String = no.toString(16)

                while (hashtext.length < 32) {
                    hashtext = "0$hashtext"
                }

                hashtext
            } catch (e: NoSuchAlgorithmException) {
                throw RuntimeException(e)
            }
        }

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use {
                    it.readText()
                }
            } catch (e: IOException) {
                e.printStackTrace()
                return null
            }
            return jsonString
        }

        @JvmStatic
        fun getDeviceName(): String {
            return Const.ANDROID + Build.MODEL
        }

        @SuppressLint("HardwareIds", "MissingPermission")
        fun getMacAddress(application: IRoomApplication): String {
            val manager = application.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val info = manager.connectionInfo
            return info.macAddress.toString()
        }

        fun validateEmail(email: String): Boolean {
            val regex = Regex(Const.EMAIL_PATTERN)
            return email.matches(regex)
        }


    }
}