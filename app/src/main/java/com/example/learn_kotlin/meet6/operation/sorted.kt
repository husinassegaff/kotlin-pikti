package com.example.learn_kotlin.meet6.operation

fun main() {
    val kotlinChar = listOf("Husin", "Hisin", "Hasin", "Hosin", "Hesin")
    val ascendingSort = kotlinChar.sorted()
    val descendingSort = kotlinChar.sortedDescending()
    println(ascendingSort)
    println(descendingSort)
}