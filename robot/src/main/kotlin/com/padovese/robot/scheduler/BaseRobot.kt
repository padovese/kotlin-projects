package com.padovese.robot.scheduler

import java.awt.Robot
import java.awt.event.KeyEvent
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

abstract class BaseRobot {
    private val DEFAULT_PATTERN = DateTimeFormatter.ofPattern("HH:mm:ss")

    fun getTime() = LocalDateTime.now().format(DEFAULT_PATTERN)

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

    fun pressF3(times: Int){
        System.setProperty("java.awt.headless", "false")
        val robot = Robot()

        for(i in 1..times){
            println("pressed $i time(s)")
            robot.keyPress(KeyEvent.VK_F3)
            robot.keyRelease(KeyEvent.VK_F3)
            Thread.sleep(2000)
            delayRange(1_000)
        }

    }

}