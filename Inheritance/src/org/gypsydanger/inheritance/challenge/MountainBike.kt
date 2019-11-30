package org.gypsydanger.inheritance.challenge

class MountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10) :
    Bicycle(cadence, speed, gear) {
    override fun description() {
        super.description()
        println("seat height: $seatHeight")
    }
}