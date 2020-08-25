package com.github.padovese.reactiveproject.repository

import com.github.padovese.reactiveproject.document.Club
import org.springframework.data.mongodb.repository.ReactiveMongoRepository


interface ClubRepository : ReactiveMongoRepository<Club, String>