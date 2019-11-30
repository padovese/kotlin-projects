package org.gypsydanger.loop

fun main(args: Array<String>) {
    for (i in 1..10) {
        println(i)
    }

    for (i in 1..6 step 2) {
        println(i)
    }

    val colors = arrayOf("green", "white", "red")
    colors.forEach { println(it) }
    colors.forEachIndexed { i, s -> println("Index $i, element $s") }

}