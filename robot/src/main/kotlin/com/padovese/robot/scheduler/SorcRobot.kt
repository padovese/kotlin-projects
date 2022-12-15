package com.padovese.robot.scheduler

import java.awt.Robot
import java.awt.event.KeyEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

//  @Component
class SorcRobot : BaseRobot(){

    @Scheduled(fixedRate = 900_000) //15m
    fun autoEat() {
        println(getTime() + " - Initiating autoEat")
        eat()
    }

    @Scheduled(fixedRate = 1200_000) //20m
    fun autoLifeRing() {
        println(getTime() + " - Initiating autoLifeRing")
        lifeRing()
    }

    @Scheduled(fixedRate = 600_000) //10m
    fun createRune(){

        println(getTime() + " - Initiating createRune")
        delayRange(30_000)

        println(getTime() + " - Command initiated: create rune")
        pressF3(6)
        println(getTime() + " - Command terminated: create rune")
    }

}