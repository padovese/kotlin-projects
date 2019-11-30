package org.gypsydanger.`when`

fun main(args: Array<String>) {
    val num = 200

    when(num){
        100 -> println("Hundred.")
        200 -> println("Two Hundred.")
        300 -> println("Three Hundred.")
        400, 500 -> println("Four or Five Hundred.")
        in 501..1000 -> println("Between Five Hundred and One to One Thousand.")
        else -> println("The value doesnt match.")
    }

    val someObj: Any = "A String for example."

    when(someObj){
        is Int -> println("It's an Int")
        is String -> println("It's a String")
        is Boolean -> println("It's a Boolean")
    }


    val a = when(someObj){
        is Int -> {
            println("It's an Int")
            1
        }
        is String -> {
            println("It's a String")
            2
        }
        is Boolean -> {
            println("It's a Boolean")
            3
        }
        else -> -1
    }

    println(a)
}