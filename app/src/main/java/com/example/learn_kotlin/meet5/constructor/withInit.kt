package com.example.learn_kotlin.meet5.constructor

class AnimalWithInit(name: String, weight: Double, age: Int, isMammal: Boolean) {
    val name: String
    val weight: Double
    val age: Int
    val isMammal: Boolean

    init {
        this.weight = if(weight < 0) 0.1 else weight
        this.age = if(age < 0) 0  else age
        this.name = name
        this.isMammal = isMammal
    }
}

fun main(){

    // constructor tanpa nilai default
    val myCat = AnimalWithInit("Miaw", 4.2, -10, true)
    println("Nama: ${myCat.name}, Berat: ${myCat.weight}, Umur: ${myCat.age}, mamalia: ${myCat.isMammal}" )
    // Output :  Nama: Miaw, Berat: 4.2, Umur: 0, mamalia: true
}