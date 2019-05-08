package com.mcb.masterclass.basics

data class Person(val name: String, var age: Int)

sealed class Tree
 object Node : Tree()
data class leaf(val left: Tree, val right: Tree, val leafData: Int) : Tree()

fun main() {
    val yash = Person("Yash", 28)
    println(yash)
    yash.age--
    println(yash)

    yash.apply {  }
}