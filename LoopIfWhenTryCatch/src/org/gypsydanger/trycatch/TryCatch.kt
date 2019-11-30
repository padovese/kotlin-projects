package org.gypsydanger.trycatch

import java.lang.NumberFormatException

fun main(args: Array<String>) {


    println(getNumber("123.5") ?: "I cant print it")

}

fun getNumber(number: String): Int? {
    return try{
        Integer.parseInt(number)
    } catch(e: NumberFormatException){
        null
    } finally {
        println("Done")
    }
}

