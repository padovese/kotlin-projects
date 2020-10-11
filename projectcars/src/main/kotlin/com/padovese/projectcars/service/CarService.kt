package com.padovese.projectcars.service

import com.padovese.projectcars.repository.CarRepository
import org.springframework.stereotype.Service

@Service
class CarService(private val carRepository: CarRepository) {
    fun getAllCars() = carRepository.findAll()


}
