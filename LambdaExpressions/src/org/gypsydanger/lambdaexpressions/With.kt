package org.gypsydanger.lambdaexpressions

fun main(args: Array<String>) {
    println(countUpTo100())
}

fun countUpTo100() =
    with(StringBuilder()) {
        for(i in 1..99){
            append(i)
            append(", ")
        }
        append("100")
        toString()
    }



