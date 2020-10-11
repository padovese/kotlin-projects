package com.padovese.projectcars.utils

import com.padovese.projectcars.document.Car
import com.padovese.projectcars.repository.CarRepository
import java.util.UUID
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired

abstract class LoadData {

    @Autowired
    private lateinit var carRepository: CarRepository

    @BeforeEach
    fun setUp() {
        val corsa = Car(UUID.randomUUID().toString(), "Corsa")
        val gol = Car(UUID.randomUUID().toString(), "Gol")
        val celta = Car(UUID.randomUUID().toString(), "Celta")
        val palio = Car(UUID.randomUUID().toString(), "Palio")

        val cars = listOf<Car>(corsa, gol, celta, palio)

        carRepository.saveAll(cars).blockLast()
    }

    @AfterEach
    fun tearUp(){
        carRepository.deleteAll().block()
    }
}