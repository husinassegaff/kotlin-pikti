package com.example.learn_kotlin.meet6.operation

fun main() {
    val number = listOf(1, 2, 3, 4, 5, 6, 2.1, "true")
    val drop = number.drop(7)
    val dropLast = number.dropLast(3)

    println(drop)
    println(drop.size)
    println(dropLast)
}