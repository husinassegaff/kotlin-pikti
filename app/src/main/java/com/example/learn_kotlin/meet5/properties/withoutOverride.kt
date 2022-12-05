package com.example.learn_kotlin.meet5.properties

class AnimalwithoutOverride{
    var name: String = "Miaw"
}

fun main(){
    val myCat = AnimalwithoutOverride()
    println("Nama: ${myCat.name}" )
    myCat.name = "Goose"
    println("Nama: ${myCat.name}")
}

/*
output:
Nama: Miaw
Nama: Goose
*/