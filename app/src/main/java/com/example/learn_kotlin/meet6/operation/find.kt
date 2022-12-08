package com.example.learn_kotlin.meet6.operation

fun main() {
    val numberList = listOf(1, 2, 3,"Kotlin", 4, 5, 6, 7, 8, 9, 10)
    val firstOddNumber = numberList.find { it == "Kotlin"}
    // val firstOrNullNumber = numberList.firstOrNull { it % 2 == 3 }
    // val lastOddNumber = numberList.findLast { it % 2 == 1 }
    // val lastOrNullNumber = numberList.lastOrNull { it % 2 == 3 }

    println(firstOddNumber)
    // println(firstOrNullNumber)
    // println(lastOddNumber)
    // println(lastOrNullNumber)
}