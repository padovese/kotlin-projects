package com.padovese.projectcars.repository

import com.padovese.projectcars.document.Car
import com.padovese.projectcars.utils.LoadData
import java.util.UUID
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.kotlin.test.test

@SpringBootTest
class CarRepositoryTest : LoadData(){

    @Autowired
    private lateinit var carRepository: CarRepository

    @Test
    fun `Should find all the cars`() {
        carRepository.findAll()
                .test()
                .expectNextCount(4)
                .verifyComplete()
    }

    @Test
    fun `Should delete, insert and find all the new cars`() {
        carRepository.deleteAll()
                .then(carRepository.save(Car(UUID.randomUUID().toString(), "Corsa")))
                .doOnNext { println(it) }
                .then(carRepository.save(Car(UUID.randomUUID().toString(), "Gol")))
                .doOnNext { println(it) }
                .thenMany(carRepository.findAll())
                .test()
                .expectNextCount(2)
                .verifyComplete()
    }

}