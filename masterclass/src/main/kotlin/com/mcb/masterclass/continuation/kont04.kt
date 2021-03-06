package com.mcb.masterclass.continuation

import com.mcb.masterclass.continuation.Kont4.addCps
import com.mcb.masterclass.continuation.Kont4.squareCps

object Kont4 {

    fun add(a: Int, b: Int) = a + b
    fun square(a: Int) = a * a

    fun addCps(a: Int, b: Int, kont: (Int) -> Unit) =  kont(add(a, b))
    fun squareCps(a: Int,kont: (Int) -> Unit) = kont(square(a))
}

fun main() {
//    val sq3 = squareCps(3)
//    val sq4 = squareCps(4)

    fun pytha(x: Int, y: Int, kont: (Int) -> Unit)= {
       squareCps(x){ sx ->
           squareCps(y){ sy : Int ->
              addCps(sx,sy,kont)
           }
       }
    }

    val result = pytha(3,4){ we -> print(we)}
    result.invoke()
}