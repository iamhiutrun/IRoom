package com.example.iroom.utils

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
            }
            catch (e: NoSuchAlgorithmException) {
                throw RuntimeException(e)
            }
        }
    }
}