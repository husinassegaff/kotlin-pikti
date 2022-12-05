package com.example.learn_kotlin.meet5.modifiers

class AnimalPrivate(private var name: String, private val weight: Double, private val age: Int, private val isMammal: Boolean = true) {

    fun getName() : String {
        return name
    }

    fun setName(newName: String) {
        name = newName
    }

}

fun main() {
    val myCat = AnimalPrivate("Miaw", 2.5, 2)
    println(myCat.getName())
    myCat.setName("Gooose")
    println(myCat.getName())
}