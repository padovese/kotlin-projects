package com.padovese.robot.controller

import java.awt.Robot
import java.awt.event.KeyEvent
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class FirstController {

    @GetMapping("/cont")
    @ResponseStatus(HttpStatus.OK)
    fun cont() : String{
        println("Test contro")

        System.setProperty("java.awt.headless", "false")

        val robot = Robot()
        println("starting pressing")
        robot.keyPress(KeyEvent.VK_A)
        robot.keyRelease(KeyEvent.VK_A)


        return "ok"
    }
}