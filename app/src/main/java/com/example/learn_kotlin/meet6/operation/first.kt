package com.example.learn_kotlin.meet6.operation

fun main() {
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val firstOddNumber = numberList.first { it % 2 == 1 }
    // val moreThan10 = numberList.first { it > 10 }
    val lastOddNumber = numberList.last { it % 2 == 1 }
    println(firstOddNumber)
    // println(moreThan10)
    println(lastOddNumber)
}