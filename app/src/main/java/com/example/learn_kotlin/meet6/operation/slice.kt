package com.example.learn_kotlin.meet6.operation

fun main() {
    val index = listOf(2, 3, 5, 8)
    val total = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val slice = total.slice(3..6)
    val sliceStepTwo = total.slice(3..6 step 2)
    val sliceIndex = total.slice(index)

    println(slice)
    println(sliceStepTwo)
    println(sliceIndex)
}