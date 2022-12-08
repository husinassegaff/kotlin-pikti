package com.example.learn_kotlin.meet6

fun main() {
    val setA  = setOf(1, 2, 4, 2, 1, 5, "Kotlin", "Java")
    val setB : Set<Int> = setOf(1, 4, 2, 5)
    val setC = setOf(1, 5, 7)

    // println(setA == setB)
    // print("Kotlin" in setA)

    val union = setA.union(setC)
    val intersect = setA.intersect(setC)

    println(union)
    println(intersect)

    val mutableSet = mutableSetOf(1, 2, 4, 2, 1, 5)
    // mutableSet[2] = 6 // tidak bisa mengubah set immutable
    mutableSet.add(6) // menambah item di akhir set
    mutableSet.remove(1) //menghapus item yang memiliki nilai 1

    println(mutableSet)
}