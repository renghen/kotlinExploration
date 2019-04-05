package com.mcb.masterclass.continuation

import com.mcb.masterclass.continuation.Kont3.const10
import com.mcb.masterclass.continuation.Kont3.step1
import com.mcb.masterclass.continuation.Kont3.step2

typealias RC<A> = ((A) -> Unit) -> Unit

infix fun<A,B> RC<A>.flatMap( f: (a : A) -> RC<B>) : RC<B> =  { cb : (B) -> Unit ->
    this{ a ->  f(a)(cb)}
}

object Kont3{
    fun add3(n: Int): RC<Int> = { kont: (Int) -> Unit -> kont(n + 3) }
    fun mult4(n: Int): RC<Int> = { kont: (Int) -> Unit -> kont(n * 4) }
    fun const(n: Int): RC<Int> = { kont: (Int) -> Unit -> kont(n) }

    val const10 = const(10)
    val step1 = { x: Int -> mult4(x) }
    val step2 = {x:Int -> add3(x)}
}

fun main() {

    val result = const10 flatMap step1 flatMap step2
    result{println(it)}
}