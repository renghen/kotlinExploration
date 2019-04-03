package com.mcb.masterclass.continuation

fun add3(n : Int, kont : (Int) -> Unit ) {
    val result = n + 3
    kont(result)
}

fun mult4(n : Int, kont : (Int) -> Unit ) {
    val result = n * 4
    kont(result)
}

fun const(n : Int, kont : (Int) -> Unit ) {
    val result = n
    kont(result)
}

fun main() {
    // add3(2){e :Int -> println(e)}
    var res = 0
    const(10){e ->
        mult4(e){f ->
            add3(f){g ->
                res = g
            }
        }
    }
    println(res)
}
