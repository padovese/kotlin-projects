package com.padovese.robot.scheduler

import java.awt.Robot
import java.awt.event.KeyEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class PallyRobot : BaseRobot() {

    @Scheduled(fixedRate = 900_000) //15m
    fun autoEat() {
        eat()
    }

    @Scheduled(fixedRate = 1200_000) //20m
    fun autoLifeRing() {
        lifeRing()
    }

    @Scheduled(fixedRate = 90_000) //1.5m
    fun createBurstArrows(){
        System.setProperty("java.awt.headless", "false")

        delayRange(30_000)

        val robot = Robot()
        println(LocalDateTime.now().toString() + "Command initiated: create burst arrows")
        robot.keyPress(KeyEvent.VK_F3)
        robot.keyRelease(KeyEvent.VK_F3)
        Thread.sleep(2000)
        delayRange(1_000)
        robot.keyPress(KeyEvent.VK_F3)
        robot.keyRelease(KeyEvent.VK_F3)
        Thread.sleep(2000)
        delayRange(1_000)
        robot.keyPress(KeyEvent.VK_F3)
        robot.keyRelease(KeyEvent.VK_F3)
        println(LocalDateTime.now().toString() + "Command terminated: create burst arrows")
    }


}