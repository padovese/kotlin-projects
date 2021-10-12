package com.padovese.robot.scheduler

import org.junit.jupiter.api.Test

class RandomTest {

    @Test
    fun randomTest(){
        println((Math.random() * 10).toLong())
    }
}