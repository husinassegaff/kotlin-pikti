package com.example.learn_kotlin.meet7

class Data(val data: Any)

fun main() {
    val dataString = Data("String")
    val valueString = dataString.data as String

    val dataInt = Data(10)
    val valueInt = dataInt.data as Int
}