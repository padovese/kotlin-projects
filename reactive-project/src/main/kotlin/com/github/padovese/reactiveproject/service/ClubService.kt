package com.github.padovese.reactiveproject.service

import com.github.padovese.reactiveproject.document.Club
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ClubService {
    fun createClub(club: Club) : Mono<Club>
    fun getClub(id: String) : Mono<Club>
    fun getAllClubs() : Flux<Club>
}