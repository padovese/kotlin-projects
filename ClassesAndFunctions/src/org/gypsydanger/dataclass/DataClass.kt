package org.gypsydanger.dataclass


val MY_CONSTANT = 1000

fun main(args: Array<String>) {
    val car = Car("Black", "GM", 2008)
    println(car)

    val car2 = Car("Black", "GM", 2008)
    println(car == car2)    //thats true because the equals method is overriden, with a regular class that would be false

    val car3 = car.copy(color = "blue") //this method create a copy of the object, and as a parameter you can inform something that may change
}

data class Car(val color: String, val model: String, val year: Int){}

