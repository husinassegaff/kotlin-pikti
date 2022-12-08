package com.example.learn_kotlin.meet6.operation

fun main() {
    val total = listOf(1, 2, 3, 4, 5, 6)
    val take = total.take(8)
    val takeLast = total.takeLast(3)

    println(take)
    println(takeLast)
}