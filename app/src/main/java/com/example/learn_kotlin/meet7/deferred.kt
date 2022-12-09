package com.example.learn_kotlin.meet7

import kotlinx.coroutines.*

private suspend fun getCapital(): Int {
    delay(7000L)
    return 50000
}

private suspend fun getIncome(): Int {
    delay(7000L)
    return 75000
}

fun main() {
    runBlocking {
        val capital = async { getCapital() }
        val income = async { getIncome() }
        println("Your profit is ${income.await()} ${capital.await()}")
    }
}