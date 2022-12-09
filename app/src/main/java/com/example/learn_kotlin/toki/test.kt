package com.example.learn_kotlin.toki

fun main(){
    val readLine = readLine()

    if (readLine != null) {
        val n = readLine.toInt()
        // print n hello world
        for (i in 1..n) {
            println("Hello World")
        }
    }
}