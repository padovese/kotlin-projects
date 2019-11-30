package org.gypsydanger.challenge

fun main(args: Array<String>) {
    //printFiveToFiveThousand()
    //printFiveHundredToZero()
    //printFibonacciSequence()
    printBackwards()
}

fun printBackwards() {
    for(i in 100 downTo 90){
        println(i)
    }
}

fun printFibonacciSequence() {
    var lastValue = 0
    var actualValue = 1
    for(i in 1..15){
        val newValue = lastValue+actualValue
        println(newValue)
        lastValue = actualValue
        actualValue = newValue
    }
}

fun printFiveHundredToZero() {
    for(i in -500..0){
        println(i)
    }
}

fun printFiveToFiveThousand() {
    for(i in 5..5000 step 5){
        println(i)
    }
}
