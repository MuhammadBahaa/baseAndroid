package com.me.baseAndroid.network

import android.os.Build


/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 5/1/20 11:05 PM
 *  * Last modified 5/1/20 11:05 PM
 *
 */
class ApiBuilder(
    private val appVersion: String, private var token: String? = null,
    private val debug: Boolean = false,
    private val tokenPrefix: String = "Token token=",
    private val serlizeNulls: Boolean = false
) : org.abanoubmilad.nut.ApiBuilder(
    enableDebug = debug,
    headers = hashMapOf(
        "Accept" to "application/json",
        "User-Agent" to "android",
        "app-version" to appVersion,
        "os-version" to Build.VERSION.RELEASE
    ).apply {
        if (!token.isNullOrBlank()) {
            put("Authorization", "$tokenPrefix$token")
        }
    },
    serializeNulls = serlizeNulls

)