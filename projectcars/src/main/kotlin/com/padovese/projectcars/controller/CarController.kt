package com.padovese.projectcars.controller

import com.padovese.projectcars.service.CarService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/cars")
class CarController(private val carService: CarService) {

    @GetMapping
    fun getAll() : Flux<CarResponseDTO> {
        return carService.getAllCars()
                .map { e -> CarResponseDTO(e.name) }
    }

}
