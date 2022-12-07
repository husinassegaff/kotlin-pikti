package com.example.learn_kotlin.meet5.modifiers

open class AnimalProtected(val name: String, protected val weight: Double)

class CatProtected(pName: String, pWeight: Double) : AnimalProtected(pName, pWeight) {

    fun getWeight() {
        println("Berat: $weight")
    }
}

fun main() {
    val cat = CatProtected("Dicoding Miaw", 2.0)
    println("Nama Kucing: ${cat.name}")
    // println("Berat Kucing: ${cat.weight}") //Cannot access 'weight': it is protected in 'Cat'

    cat.getWeight()
}