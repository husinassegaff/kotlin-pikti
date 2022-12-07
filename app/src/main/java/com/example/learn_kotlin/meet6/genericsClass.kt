package com.example.learn_kotlin.meet6

class MyData<T>(val firstData: T) {

    fun getData(): T {
        return firstData
    }

    fun printFirstData() {
        println(firstData)
    }
}

fun main() {
    val myDataString = MyData<String>("String")
    val myDataInt = MyData<Int>(10)

    var x = "${myDataInt.getData()} ${myDataString.getData()}"

    myDataString.printFirstData()
    myDataInt.printFirstData()
    println(x)
}