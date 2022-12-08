package com.example.learn_kotlin.meet6.operation

fun main() {
    val numbers = listOf(1, 2, 3)
    val fold = numbers.fold(0) { current, item ->
        println("current $current")
        println("item $item\n")
        current + item
    }

    println("Fold result: $fold")

    /*output:
           current 10
           item 1

           current 11
           item 2

           current 13
           item 3

           Fold result: 16
    */
}