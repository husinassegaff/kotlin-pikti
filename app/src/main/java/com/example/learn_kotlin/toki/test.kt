package com.example.learn_kotlin.toki

fun main(): String {
    val readLine = readLine()

    if (readLine != null) {
        val n = readLine.toInt()
        if (n in 0..100) {
            return "YA"
        } else {
            return "TIDAK"
        }
    }

    return "TIDAK"
}