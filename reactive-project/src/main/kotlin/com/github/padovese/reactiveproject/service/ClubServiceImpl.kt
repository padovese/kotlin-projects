package com.github.padovese.reactiveproject.service

import com.github.padovese.reactiveproject.document.Club
import com.github.padovese.reactiveproject.repository.ClubRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
private class ClubServiceImpl(private val clubRepository: ClubRepository) : ClubService{

    override fun createClub(club: Club): Mono<Club> {
        return clubRepository.save(club)
    }

    override fun getClub(id: String): Mono<Club> {
        return clubRepository.findById(id)
    }

    override fun getAllClubs(): Flux<Club> {
        return clubRepository.findAll()
    }
}