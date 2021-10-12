package com.padovese.robot.scheduler

import java.awt.Robot
import java.awt.event.KeyEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class FirstRobot {

    @Scheduled(fixedRate = 150_000) //2m
    fun createBurstArrows(){
        System.setProperty("java.awt.headless", "false")

        delayRange(30_000)

        val robot = Robot()
        println("Command initiated: exevo con flam")
        robot.keyPress(KeyEvent.VK_E)
        robot.keyRelease(KeyEvent.VK_E)
        robot.keyPress(KeyEvent.VK_X)
        robot.keyRelease(KeyEvent.VK_X)
        robot.keyPress(KeyEvent.VK_E)
        robot.keyRelease(KeyEvent.VK_E)
        robot.keyPress(KeyEvent.VK_V)
        robot.keyRelease(KeyEvent.VK_V)
        robot.keyPress(KeyEvent.VK_O)
        robot.keyRelease(KeyEvent.VK_O)
        robot.keyPress(KeyEvent.VK_SPACE)
        robot.keyRelease(KeyEvent.VK_SPACE)
        robot.keyPress(KeyEvent.VK_C)
        robot.keyRelease(KeyEvent.VK_C)
        robot.keyPress(KeyEvent.VK_O)
        robot.keyRelease(KeyEvent.VK_O)
        robot.keyPress(KeyEvent.VK_N)
        robot.keyRelease(KeyEvent.VK_N)
        robot.keyPress(KeyEvent.VK_SPACE)
        robot.keyRelease(KeyEvent.VK_SPACE)
        robot.keyPress(KeyEvent.VK_F)
        robot.keyRelease(KeyEvent.VK_F)
        robot.keyPress(KeyEvent.VK_L)
        robot.keyRelease(KeyEvent.VK_L)
        robot.keyPress(KeyEvent.VK_A)
        robot.keyRelease(KeyEvent.VK_A)
        robot.keyPress(KeyEvent.VK_M)
        robot.keyRelease(KeyEvent.VK_M)
        robot.keyPress(KeyEvent.VK_ENTER)
        robot.keyRelease(KeyEvent.VK_ENTER)
        println("Command terminated: exevo con flam")
    }

    @Scheduled(fixedRate = 300_000) //5m
    fun antiIdle() {
        System.setProperty("java.awt.headless", "false")

        delayRange(120_000)

        val robot = Robot()
        println("Command initiated: anti idle")
        robot.keyPress(KeyEvent.VK_CONTROL)
        getRandomArrowKey()
        delayRange(2_000)
        getRandomArrowKey()
        robot.keyRelease(KeyEvent.VK_CONTROL)
        println("Command terminated: anti idle")
    }

    @Scheduled(fixedRate = 360_000) //5m
    fun autoEat() {
        System.setProperty("java.awt.headless", "false")

        delayRange(120_000)

        val robot = Robot()
        println("Command initiated: auto eat")
        robot.keyPress(KeyEvent.VK_F7)
        robot.keyRelease(KeyEvent.VK_F7)
        println("Command terminated: auto eat")
    }

    fun delayRange(range: Long) = Thread.sleep((Math.random() * range).toLong())

    fun getRandomArrowKey(){
        val robot = Robot()

        val keyEvent = when((Math.random() * 10).toLong()){
            0L -> KeyEvent.VK_UP
            1L -> KeyEvent.VK_UP
            2L -> KeyEvent.VK_UP
            3L -> KeyEvent.VK_DOWN
            4L -> KeyEvent.VK_DOWN
            5L -> KeyEvent.VK_DOWN
            6L -> KeyEvent.VK_LEFT
            7L -> KeyEvent.VK_LEFT
            8L -> KeyEvent.VK_RIGHT
            9L -> KeyEvent.VK_RIGHT
            else -> KeyEvent.VK_RIGHT

        }
        robot.keyPress(keyEvent)
        robot.keyRelease(keyEvent)
    }

}