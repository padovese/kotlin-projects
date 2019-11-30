package org.gypsydanger.inheritance.challenge

class RoadBike(cadence: Int, speed: Int, gear: Int = 10, val tireWidth: Int):
    Bicycle(cadence, speed, gear){
    override fun description() {
        super.description()
        println("tire width: $tireWidth")
    }
}