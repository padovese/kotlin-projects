package org.gypsydanger.functions


//You will add a function to an Object, like in JS

fun main(args: Array<String>) {
    println("padovese".addPlusCharBeforeAndAfter())
}

fun String.addPlusCharBeforeAndAfter(): String {
    return StringBuilder()
        .append("+")
        .append(this)
        .append("+")
        .toString()
}