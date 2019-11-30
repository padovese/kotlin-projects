package org.gypsydanger.iff

fun main(args: Array<String>) {
    val num = if(true) 40 else 50

    val num2 = if(true){
        10
        20
        println("lol")
    } else{
        30
        40
    }

    println(num2)

    println("A if inside a print or could be inside a parameter or anywhere: ${if (true){"YES"}else{("NO")}}")
}
