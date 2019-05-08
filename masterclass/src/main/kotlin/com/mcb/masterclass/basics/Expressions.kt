package com.mcb.masterclass.basics

fun main() {

    val age = 21

    val result = if (age < 30) "young" else 5

    val someNumber = "4"
    val number = try {
        someNumber.toInt()
    } catch (e: Exception) {
        0
    }
    println(number)

    val grade = when (number) {
        in 1..30 -> "F"
        in 31..40 -> "E"
        in 41..50 -> "D"
        else -> "A"
    }

    val range = 1..30

}