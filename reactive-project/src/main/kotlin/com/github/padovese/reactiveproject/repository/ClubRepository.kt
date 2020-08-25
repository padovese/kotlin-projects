package com.github.padovese.reactiveproject.repository

import com.github.padovese.reactiveproject.document.Club
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClubRepository : ReactiveMongoRepository<Club, String>