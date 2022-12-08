package com.example.learn_kotlin.meet6

fun main() {
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenList = numberList.filter { x -> x % 2 == 0 }
    val notEvenList = numberList.filterNot { it % 2 == 0 }

    println(evenList)
    println(notEvenList)

    // evenList: [2, 4, 6, 8, 10]
    // notEvenList: [1, 3, 5, 7, 9]
}