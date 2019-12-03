package org.gypsydanger.lambdaexpressions

fun main(args: Array<String>) {
    println(countUpTo100())
    println(countFrom100())
}

//Return any type
fun countUpTo100() =
    with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append("100")
        toString()
    }

//Return the same type
fun countFrom100() =
    StringBuilder().apply {
        for (i in 100 downTo 2) {
            append(i)
            append(", ")
        }
        append("1")
    }.toString()



