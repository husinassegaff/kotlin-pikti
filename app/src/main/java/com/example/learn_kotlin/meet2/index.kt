package com.example.learn_kotlin.meet2

import com.example.learn_kotlin.meet5.constructor.AnimalWithInit

var a = 1

fun main() {

    var officeOpen = 7
    var officeClose = 16
    var now = 8

    var myCat = AnimalWithInit("Miaw", 4.2, -10, true)

    /*
        true = 1 , false = 0
        AND
        true && true = true
        true && false = false
        false && true = false
        false && false = false

        OR
        true || true = true
        true || false = true
        false || true = true
        false || false = false

        NOT
        !true = false
        !false = true


     */

    val isOpen = now > officeOpen && now < officeClose
    val isClose = now < officeOpen || now > officeClose

//    if (now in (officeOpen + 1) until officeClose) {
//        println("Office is close")
//    } else if (isClose) {
//        println("Office is open")
//    } else {
//        println("Office is closed")
//    }

    val x = 0.1234567891
    val y = 0.1234567891f

    val arrayX = arrayOf(1, "ITS", true, 4)
    val arrayY = Array(5, { i -> i })

//    for (i in arrayY) {
//        println(i)
//    }
//
    var stringX = "hello"
//    print(stringX.length)

    var nullVariable : String? = null
    nullVariable = "hello"

    var stringLength = nullVariable.length

    stringLength = nullVariable.length
    // print(stringLength)

    var modX = 10
    var modY = 3

    modX = modX + 2
    modX += 2

//    var nameAge = setName2("Husin", 21)
//    println(nameAge)

//    var keliling = kelilingPersegi(3)
//    println(keliling)

    print("Masukkan nilai: ")
    val input = readLine()
    println(input)

}

fun kelilingPersegi(sisi: Int): Int {
    return sisi * 4
}

fun setName(name: String, age: Int) {
    print("My name is $name and my age is $age")
}

fun setName2(name: String, age: Int) = "$name is $age years old"
