package com.example.learn_kotlin.meet7

class GenericsFunction(val name: String) {

    fun <T> sayHello(param: T) {
        println("Hello $param, My name is $name")
    }
}

fun main() {
    val x = GenericsFunction("Pikti")

    x.sayHello<String>("Husin")
    x.sayHello("Husin")

    x.sayHello(10)
    x.sayHello(10.0)
    x.sayHello(true)
}