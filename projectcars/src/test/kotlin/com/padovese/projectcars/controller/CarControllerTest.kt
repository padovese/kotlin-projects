package com.padovese.projectcars.controller

import com.padovese.projectcars.dto.CarResponseDTO
import com.padovese.projectcars.utils.LoadData
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.kotlin.test.test

@SpringBootTest
class CarControllerTest : LoadData() {

    @Autowired
    lateinit var carController: CarController

    @Test
    fun `Should return a Flux of four DTOs`() {
        carController.getAll()
                .test()
                .expectNextMatches { e -> e is CarResponseDTO }
                .expectNextMatches { e -> e is CarResponseDTO }
                .expectNextMatches { e -> e is CarResponseDTO }
                .expectNextMatches { e -> e is CarResponseDTO }
                .verifyComplete()
    }

    @Test
    fun `Should verify the name`() {
        carController.getAll()
                .test()
                .expectNextMatches { e -> e.name == "Corsa" }
                .expectNextMatches { e -> e.name == "Gol" }
                .expectNextMatches { e -> e.name == "Celta" }
                .expectNextMatches { e -> e.name == "Palio" }
    }

}