package org.gypsydanger.inheritance.challenge

open class Bicycle(var cadence: Int, var speed: Int, var gear: Int = 10){
    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun description() = println("Bike is in gear $gear, with a cadence of $cadence, in speed $speed.")
}

fun main(args: Array<String>) {
    val a = Bicycle(0, 0)
    val b = RoadBike(0,0, tireWidth = 5)
    val c = MountainBike(10,0,0)
    a.description()
    b.description()
    c.description()
}