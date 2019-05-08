package com.mcb.masterclass.basics

import org.slf4j.Logger
import kotlinx.coroutines.withTimeout
import java.io.IOException
import java.util.*

fun get(path: String): String =
Random().nextInt(10).let {
    when {
        it < 2 -> throw IOException("Error accessing file $path")
        else -> "content of $path"
    }
}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach{
        if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
    print(" done with explicit label")
}

@Throws(Exception::class)
suspend fun <T> retry(block: suspend () -> T, logger : Logger,timeOut : Long = 500, retries : Int = 5): T {
        for (i in 2..retries) {
           try {
               return  withTimeout(timeOut) {
                    // with timeout
                    block()
                }
            } catch (e: Exception) {
               logger.error("{retry:${e.message}}")
               logger.error("{retry:${e.cause}}")
               logger.error("{retry:${e}}")
            }
        }

    return  withTimeout(timeOut) {
        block()
    }
}

fun main() {
//    loop@ for (i in 1..100) {
//        for (j in 1..100) {
//            if ((j%100) == 0) {
//                println(j)
//                break@loop
//            }
//        }
//    }
//    foo()

    for (i in 2..5) println(i)

}
