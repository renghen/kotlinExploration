package com.mcb.masterclass.arrow

import kotlinx.coroutines.runBlocking
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult

fun main() {

    runBlocking {
        Fuel.get("https://httpbin.org/ip")
            .awaitStringResponseResult().third
            .fold(
                { data -> println(data) /* "{"origin":"127.0.0.1"}" */ },
                { error -> println("An error of type ${error.exception} happened: ${error.message}") }
            )
    }


}