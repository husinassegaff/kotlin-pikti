package com.example.learn_kotlin.meet7

class DataGeneric<T>(val data: T)

fun main() {
    val dataString = DataGeneric<String>("String")
    val valueString = dataString.data

    val dataInt = DataGeneric<Int>(10)
    val valueInt = dataInt.data as Int
}