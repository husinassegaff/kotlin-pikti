package com.example.learn_kotlin.meet5

interface IFly {
    fun fly()
    fun eat()
    val numberOfWings: Int
    val numberOfLegs: Int
}

class Bird(override val numberOfWings: Int, override val numberOfLegs: Int) : IFly {
    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }


}

fun main() {


    val bird = Bird(2, 2)
    bird.fly()
}