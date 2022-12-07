package com.example.learn_kotlin.meet5

abstract class Animal(var name: String, var weight: Double, var age: Int, var isCarnivore: Boolean){

    open fun eat(){
        println("$name sedang makan !")
    }

    fun sleep(){
        println("$name sedang tidur !")
    }
}

class Cat(name: String, weight: Double, age: Int, isCarnivore: Boolean) : Animal(name, weight, age, isCarnivore){

    override fun eat() {
        println("$name sedang makan ikan !")
    }

    fun meow(){
        println("Meow Meow")
    }
}

fun main(){
    // val animal = Animal("Kucing", 4.2, 2, false)
    // error : Cannot create an instance of an abstract class

    /*
    tidak error karena class Cat
    sudah mengimplementasikan semua
    method yang ada di abstract class Animal
     */
    val cat = Cat("Kucing", 4.2, 2, false)

    cat.eat()
}