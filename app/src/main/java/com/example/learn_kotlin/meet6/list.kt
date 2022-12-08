package com.example.learn_kotlin.meet6



fun main() {

    val numberList = listOf(1, 2, 3, 4, 5)
    val charList = listOf('a', 'b', 'c')
    val anyList = mutableListOf('a', "Kotlin", 3, true, 3.14, 3.14f, 3L)

    anyList.add('d') // menambah item di akhir list
    anyList.add(1, "love") // menambah item pada indeks ke-1
    anyList[100] = false // mengubah nilai item pada indeks ke-3
    // anyList.removeAt(0) // menghapus item pada indeks ke-0

    println(anyList)

}