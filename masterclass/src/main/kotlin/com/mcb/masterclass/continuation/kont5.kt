package com.mcb.masterclass.continuation

object Kont5 {

    fun add(a: Int) = { b: Int -> a + b }
    fun square(a: Int) = a * a

    fun addCps(a: Int) = { b: Int -> { kont: (Int) -> Unit -> kont(add(a)(b)) } }
    fun squareCps(a: Int) = { kont: (Int) -> Unit -> kont(square(a)) }

    fun pytha1(x: Int, y: Int, kont: (Int) -> Unit) = addCps(square(x))(square(y))(kont)

    fun pytha2(x: Int, y: Int, kont: (Int) -> Unit) {
        squareCps(x)() { xx ->
            squareCps(y)() { yy ->
                addCps(xx)(yy)(kont)
            }
        }
    }

    fun pytha3(x: Int) = { y: Int ->
        { kont: (Int) -> Unit ->
            squareCps(x)() { xx ->
                squareCps(y)() { yy ->
                    addCps(xx)(yy)(kont)
                }
            }
        }
    }

}

fun main() {
    println(Kont5.pytha3(3)(4)() { r: Int -> println(r) })
}