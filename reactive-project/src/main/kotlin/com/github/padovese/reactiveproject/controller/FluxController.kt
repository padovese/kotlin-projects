package com.github.padovese.reactiveproject.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
class FluxController {

    @GetMapping("/flux", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun flux() =
        Flux.just("Pa", "do", "ve", "se").delayElements(Duration.ofSeconds(1))

}