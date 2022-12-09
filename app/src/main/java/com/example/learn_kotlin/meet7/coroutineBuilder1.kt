package com.example.learn_kotlin.meet7
import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
            println("Coroutines!")
        }
        println("Hello,")

    }
}