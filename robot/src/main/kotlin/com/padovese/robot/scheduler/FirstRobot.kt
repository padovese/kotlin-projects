package com.padovese.robot.scheduler

import java.awt.Robot
import java.awt.event.KeyEvent
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class FirstRobot {

    @Scheduled(fixedRate = 5000)
    fun first(){
        System.setProperty("java.awt.headless", "false")

        val robot = Robot()
        println("starting pressing")
        robot.keyPress(KeyEvent.VK_A)
        robot.keyRelease(KeyEvent.VK_A)
        println("keys pressed.")
    }

}