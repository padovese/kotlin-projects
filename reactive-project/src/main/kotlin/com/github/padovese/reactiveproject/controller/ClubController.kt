package com.github.padovese.reactiveproject.controller

import com.github.padovese.reactiveproject.document.Club
import com.github.padovese.reactiveproject.service.ClubService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuple2
import java.time.Duration

@RestController
@RequestMapping("/club")
class ClubController(private val clubService: ClubService) {

    @GetMapping("/{id}")
    fun getClub(@PathVariable id: String) : Mono<Club> {
        return clubService.getClub(id)
    }

    @GetMapping
    fun getAllClubs() : Flux<Club> {
        return clubService.getAllClubs()
    }

    @PostMapping
    fun create(@RequestBody club: Club) : Mono<Club>{
        return clubService.createClub(club)
    }

    @GetMapping("/events", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getClubsEvents() : Flux<Tuple2<Long, Club>>{
        val interval : Flux<Long> = Flux.interval(Duration.ofSeconds(10))
        val events : Flux<Club> = clubService.getAllClubs()
        return Flux.zip(interval, events)
    }

}