package com.example.learn_kotlin.meet6.operation

fun main() {
    val numberList = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val multipliedBy5 = numberList.map { y ->

        if (y % 2 == 0) {
            y * 5
        } else {
            y
        }
    }

    println(multipliedBy5)
}