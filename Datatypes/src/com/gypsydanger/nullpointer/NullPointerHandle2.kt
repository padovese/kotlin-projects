package com.gypsydanger.nullpointer

fun main(args: Array<String>) {
    var str: String? = null
    println(str?.toUpperCase())     //will only print null
    println(str!!.toUpperCase())    //enforcing kotlin to belieave that this will never be null, so if its null, youll finally get an exception

    str?.let { println("never gonna happen, cause string is null") }
    str = "hello"
    str?.let { println("now it gonna be printed") }

    val str2: String? = null
    val str3 = "not null"
    if(str2 == str3){
        println("will never print, because == is null safety, result is false")
    }
}