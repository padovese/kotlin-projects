package com.padovese.robot.scheduler

import java.awt.Robot
import java.awt.event.KeyEvent
import java.time.LocalDateTime

abstract class BaseRobot {

    fun delayRange(range: Long) = Thread.sleep((Math.random() * range).toLong())

    fun lifeRing() {
        System.setProperty("java.awt.headless", "false")

        delayRange(60_000)

        val robot = Robot()
        println(LocalDateTime.now().toString() + " - Command initiated: auto life ring")
        robot.keyPress(KeyEvent.VK_F2)
        robot.keyRelease(KeyEvent.VK_F2)
        println(LocalDateTime.now().toString() + " - Command terminated: auto life ring")
    }

    fun eat() {
        System.setProperty("java.awt.headless", "false")

        delayRange(300_000)

        val robot = Robot()
        println(LocalDateTime.now().toString() + "Command initiated: auto eat")
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
        println(LocalDateTime.now().toString() + "Command terminated: auto eat")
    }


}