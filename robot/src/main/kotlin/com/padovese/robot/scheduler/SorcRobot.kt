package com.padovese.robot.scheduler

import java.awt.Robot
import java.awt.event.KeyEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class SorcRobot {

    @Scheduled(fixedRate = 900_000) //15m
    fun autoEat() {
        System.setProperty("java.awt.headless", "false")

        delayRange(300_000)

        val robot = Robot()
        println("Command initiated: auto eat")
        robot.keyPress(KeyEvent.VK_F1)
        robot.keyRelease(KeyEvent.VK_F1)
        delayRange(1_000)
        robot.keyPress(KeyEvent.VK_F1)
        robot.keyRelease(KeyEvent.VK_F1)
        delayRange(1_000)
        robot.keyPress(KeyEvent.VK_F1)
        robot.keyRelease(KeyEvent.VK_F1)
        delayRange(1_000)
        robot.keyPress(KeyEvent.VK_F1)
        robot.keyRelease(KeyEvent.VK_F1)
        println("Command terminated: auto eat")
    }

    @Scheduled(fixedRate = 1200_000) //20m
    fun autoLifeRing() {
        System.setProperty("java.awt.headless", "false")

        delayRange(60_000)

        val robot = Robot()
        println("Command initiated: auto life ring")
        robot.keyPress(KeyEvent.VK_F2)
        robot.keyRelease(KeyEvent.VK_F2)
        println("Command terminated: auto life ring")
    }

    @Scheduled(fixedRate = 600_000) //10m
    fun createRune(){
        System.setProperty("java.awt.headless", "false")

        delayRange(30_000)

        val robot = Robot()
        println("Command initiated: create rune")
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
        Thread.sleep(2000)
        delayRange(1_000)
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
        println("Command terminated: create rune")
    }

    fun delayRange(range: Long) = Thread.sleep((Math.random() * range).toLong())

}