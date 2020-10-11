package com.padovese.projectcars.service

import com.padovese.projectcars.utils.LoadData
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.kotlin.test.test

@SpringBootTest
class CarServiceTest : LoadData() {

    @Autowired
    lateinit var carService: CarService

    @Test
    fun `Should get all the cars`(){
        carService.getAllCars()
                .test()
                .expectNextCount(4)
                .expectComplete()
    }
}