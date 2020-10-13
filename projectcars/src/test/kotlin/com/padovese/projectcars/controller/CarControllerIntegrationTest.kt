package com.padovese.projectcars.controller

import com.nhaarman.mockitokotlin2.whenever
import com.padovese.projectcars.document.Car
import com.padovese.projectcars.dto.CarResponseDTO
import com.padovese.projectcars.repository.CarRepository
import com.padovese.projectcars.service.CarService
import java.util.UUID
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux

@WebFluxTest
class CarControllerIntegrationTest {

    @MockBean
    lateinit var carService: CarService

    @MockBean
    lateinit var carRepository: CarRepository

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun `Should get all cars`() {

        val cars = Flux.just(Car(UUID.randomUUID().toString(), "Corsa"),
        Car(UUID.randomUUID().toString(), "Gol"),
        Car(UUID.randomUUID().toString(), "Celta"),
        Car(UUID.randomUUID().toString(), "Palio"))

        whenever(carService.getAllCars()).thenReturn(cars)

        webTestClient
                .get()
                .uri("/cars")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(CarResponseDTO::class.java)
                .hasSize(4)
    }
}