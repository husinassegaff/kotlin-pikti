package com.example.learn_kotlin.meet5

/*
 * Untuk membuat sebuah super atau parent class, akan membutuhkan open class.
 * Kelas pada Kotlin secara default bersifat final,
 * oleh karena itu diubah menjadi open class sebelum melakukan extends kelas tersebut.
 *
 * */

open class AnimalInheritance(val name: String, val weight: Double, val age: Int, val isCarnivore: Boolean){

    open fun eat(){
        println("$name sedang makan!")
    }

    open fun sleep(){
        println("$name sedang tidur!")
    }
}

class CatInheritance(pName: String, pWeight: Double, pAge: Int, pIsCarnivore: Boolean, val furColor: String, val numberOfFeet: Int)
    : AnimalInheritance(pName, pWeight, pAge, pIsCarnivore) {

    fun playWithHuman() {
        println("$name bermain bersama Manusia !")
    }

    override fun eat(){
        println("$name sedang memakan ikan !")
    }

    override fun sleep() {
        println("$name sedang tidur di bantal !")
    }
}

fun main(){
    val myCat = CatInheritance("Miaw", 3.2, 2, true, "Brown", 4)

    myCat.playWithHuman()
    myCat.eat()
    myCat.sleep()
}