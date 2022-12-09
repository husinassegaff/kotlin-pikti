package com.example.learn_kotlin.meet7

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

private suspend fun getCapital(): Int {
    delay(1000L)
    return 50000
}

private suspend fun getIncome(): Int {
    delay(1000L)
    return 75000
}


fun main() {


    runBlocking {

        // Pada kode di bawah, menggunakan pendekatan sequential
        val timeOne = measureTimeMillis {
            val capital = getCapital()
            val income = getIncome()
            println("Your profit is ${income - capital}")
        }

        /* memanggil fungsi getCapital dan getIncome di dalam async.
           Maka async akan mengembalikan hasil dari
           masing-masing fungsi.
         */
        val timeTwo = measureTimeMillis {
            val capital = async { getCapital() }
            val income = async { getIncome() }
            println("Your profit is ${income.await() - capital.await()}")
        }

        println("Completed in $timeOne ms vs $timeTwo ms")
    }
}