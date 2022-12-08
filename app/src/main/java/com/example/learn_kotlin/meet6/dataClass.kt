package com.example.learn_kotlin.meet6

class User(val name : String, val age : Int) {
/*
    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }
*/
    fun toString(x: String): String {
        return "User(name=$name, age=$age) $x"
    }



}

data class DataUser(val name: String, val age: Int)

fun main() {
    val user = User("John", 25)
    val dataUser = DataUser("nrohmen", 17)

    val dataUser2 = dataUser.copy()
    val dataUser3 = dataUser.copy(age = 18)

    println(user)
    println(user.toString("ini toString() buatan sendiri"))
    // println(dataUser)

    // println(dataUser2)
    // println(dataUser3)
}