package com.example.learn_kotlin.meet5.properties

class AnimalwithOverride{
    var name: String = "Miaw"
    var weight: Double = 4.2
        get(){
            println("Fungsi Getter terpanggil")

            return field
        }
        set(value){
            println("Fungsi Setter terpanggil")
            field = value
        }
}

fun main(){
    val myCat = AnimalwithOverride()
    println("Nama: ${myCat.name}" )
    println("Nama: ${myCat.weight}" )
    myCat.name = "Goose"
    println("Nama: ${myCat.name}")
}