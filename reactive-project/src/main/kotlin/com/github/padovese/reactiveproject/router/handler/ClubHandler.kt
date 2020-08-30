package com.github.padovese.reactiveproject.router.handler

import com.github.padovese.reactiveproject.document.Club
import com.github.padovese.reactiveproject.service.ClubService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class ClubHandler(private val clubService: ClubService) {

    fun getClub(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clubService.getClub(serverRequest.pathVariable("id")), Club::class.java)
    }

    fun getAllClubs(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clubService.getAllClubs(), Club::class.java)
    }

    fun create(serverRequest: ServerRequest): Mono<ServerResponse> {
        val club: Mono<Club> = serverRequest.bodyToMono(Club::class.java)
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(club.flatMap(clubService::createClub), Club::class.java))
    }

}