package com.github.padovese.reactiveproject

import com.github.padovese.reactiveproject.document.Club
import com.github.padovese.reactiveproject.repository.ClubRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.*

@Component
class DumpStartData(private val clubRepository: ClubRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        clubRepository
                .deleteAll()
                .thenMany(
                        Flux.just("Barcelona",
                                "Paris Saint-Germain",
                                "Real Madrid",
                                "Milan",
                                "Napoli",
                                "Cagliari Calcio")
                .map { club -> Club(UUID.randomUUID().toString(), club) }
                .flatMap { club -> clubRepository.save(club) })
                .subscribe{ e -> println(e)}
    }

}