package com.pikti.app_one.common

import android.location.Location
import java.text.SimpleDateFormat
import java.util.*

class Common {
    companion object {
        val APP_ID = "1ab3ddd00b93889a90e5a1a8f1c8f639"
        var current_location: Location? = null

        fun convertUnixToDate(dt: Int): String? {
            val date = Date(dt * 1000L)
            val sdf = SimpleDateFormat("HH:mm")
            return sdf.format(date)
        }

        fun convertUnixToHour(dt: Int): String? {
            val date = Date(dt * 1000L)
            val sdf = SimpleDateFormat("HH:mm EEE MM yyyy")
            return sdf.format(date)
        }
    }
}