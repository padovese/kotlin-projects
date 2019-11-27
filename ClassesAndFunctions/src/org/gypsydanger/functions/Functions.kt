package org.gypsydanger.functions

package org.gypsydanger.accessmodifiers

fun main(args: Array<String>) {
    println(labelMultiply(2, 5, "The result:"))
    println(labelMultiply2(4, 5, "The result:"))

    printAllCars(
        Car("Black", "GM", 2008),
        Car("White", "FIAT", 2018),
        Car("Blue", "TOYOTA", 2015)
    )
}

fun labelMultiply(arg1: Int, arg2: Int, label: String): String {
    return "$label ${arg1 * arg2}"
}

//if its a one line method, you could do:
fun labelMultiply2(arg1: Int, arg2: Int, label: String): String = "$label ${arg1 * arg2}"

//varargs, here you can use parameters after or before vararg
fun printAllCars(vararg cars: Car) {
    for (car in cars) {
        println(car)
    }
}

//The spread operator here is *, you put it before the array reference to split the array into the objects