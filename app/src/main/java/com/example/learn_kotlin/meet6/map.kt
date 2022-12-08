package com.example.learn_kotlin.meet6

fun main() {
    val capital = mapOf(
        "Jawa Timur" to listOf("Surabaya", "Malang", "Blitar"),
        "Surabaya" to "Indonesia",
        "London" to "England",
        "New Delhi" to "India",
        "New Delhi" to "Mumbai",
        1 to true,
        false to 2
    )


    // println(capital["Jakarta"])
    // println(capital.getValue("Jakarta"))

    // println(capital["Amsterdam"]) // Output: null

    // println(capital.getValue("Amsterdam")) // Output: Exception in thread "main" java.util.NoSuchElementException: Key Amsterdam is missing in the map.

    val mapKeys = capital.keys
    val mapValues = capital.values

    // println(mapKeys)
    println(mapValues)

    val mutableCapital = capital.toMutableMap()
    mutableCapital.put("Amsterdam", "Netherlands")
    mutableCapital.put("Berlin", "Germany")

}