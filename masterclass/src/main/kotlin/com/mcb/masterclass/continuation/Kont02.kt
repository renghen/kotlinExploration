package com.mcb.masterclass.continuation

fun main() {
    fun add3(n : Int) = { kont : (Int) -> Unit  -> kont(n + 3) }
    fun mult4(n : Int) = { kont : (Int) -> Unit  -> kont(n * 4) }
    fun const(n : Int)= { kont : (Int) -> Unit  -> kont(n ) }
    val const10 = const(10)
}