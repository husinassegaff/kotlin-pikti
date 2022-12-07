package com.example.learn_kotlin.meet5

class AnimalClass(val name: String,
             val weight: Double,
             val age: Int,
             val isMammal: Boolean
) {

    fun eat(){
        println("$name makan!")
    }

    fun sleep() {
        println("$name tidur!")
    }
}

fun main() {
    val myCat = AnimalClass("Miaw", 4.2, 2,true)
    val myDog = AnimalClass("Kitten", 4.2, 2,true)


    println("Nama: ${myCat.name}, Berat: ${myCat.weight}, Umur: ${myCat.age}, mamalia: ${myCat.isMammal}" )
    myCat.eat()
    myCat.sleep()
}