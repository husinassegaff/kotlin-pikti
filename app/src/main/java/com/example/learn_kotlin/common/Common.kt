package com.example.learn_kotlin.common

import android.location.Location
import java.text.SimpleDateFormat
import java.util.*

class Common {
    val APP_ID = "4ca775042db05cedbbe80895b18afb62"
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