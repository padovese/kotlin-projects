package com.padovese.projectcars.repository

import com.padovese.projectcars.document.Car
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : ReactiveMongoRepository<Car, String>
