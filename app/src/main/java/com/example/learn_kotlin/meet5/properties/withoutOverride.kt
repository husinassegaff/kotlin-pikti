package com.example.learn_kotlin.meet5.properties

class AnimalwithoutOverride{
    var name: String = "Miaw"

    get() {
        return field
    }

    set(value) {
        field = value
    }
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