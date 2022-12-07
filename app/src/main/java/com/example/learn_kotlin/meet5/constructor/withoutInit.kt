package com.example.learn_kotlin.meet5.constructor

// class tanpa nilai default
class Animal(val name: String,
             val weight: Double,
             val age: Int,
             val isMammal: Boolean)

// class dengan nilai default pada age dan isMammal
class Animal2(var name: String,
              var weight: Double,
              var age: Int = 0,
              var isMammal: Boolean = true)



fun main(){

    // constructor tanpa nilai default
    val myCat = Animal("Miaw", 4.2, 2, true)
    println("Nama: ${myCat.name}, Berat: ${myCat.weight}, Umur: ${myCat.age}, mamalia: ${myCat.isMammal}" )
    // Output :  Nama: Miaw, Berat: 4.2, Umur: 2, mamalia: true


    // constructor dengan nilai default pada age dan isMammal
    val myCat2 = Animal2("Kitten", 4.2, 5, false)
    println("Nama: ${myCat2.name}, Berat: ${myCat2.weight}, Umur: ${myCat2.age}, mamalia: ${myCat2.isMammal}" )

    // eksplisit mengisi nilai isMammal
    val myCat3 = Animal2(isMammal = false, name = "Kitten", weight = 4.2, age = 5)
    println("Nama: ${myCat3.name}, Berat: ${myCat3.weight}, Umur: ${myCat3.age}, mamalia: ${myCat3.isMammal}" )
}