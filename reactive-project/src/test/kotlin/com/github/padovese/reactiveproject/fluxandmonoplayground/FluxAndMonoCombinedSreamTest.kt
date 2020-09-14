package com.github.padovese.reactiveproject.fluxandmonoplayground

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.time.Duration
import java.util.function.BiFunction


class FluxAndMonoCombinedSreamTest {

    @Test
    fun combineFlux(){
        val fluxA = Flux.just("P", "A", "D", "O")
        val fluxB = Flux.just("V", "E", "S", "E")
        val  mono = Mono.just("!")

        val fluxC = Flux.merge(fluxA, fluxB, mono)

        StepVerifier.create(fluxC)
                .expectNext("P", "A", "D", "O", "V", "E", "S", "E", "!")
                .verifyComplete()
    }

    @Test
    fun combineFlux_withDelay(){
        val fluxA = Flux.just("P", "A", "D", "O").delayElements(Duration.ofSeconds(1))
        val fluxB = Flux.just("V", "E", "S", "E").delayElements(Duration.ofSeconds(1))
        val  mono = Mono.just("!")

        val fluxC = Flux.merge(fluxA, fluxB, mono)

        StepVerifier.create(fluxC.log())
                .expectNextCount(9)
                .verifyComplete()
    }

    @Test
    fun combineFlux_withDelay_withOrder(){
        val fluxA = Flux.just("P", "A", "D", "O").delayElements(Duration.ofSeconds(1))
        val fluxB = Flux.just("V", "E", "S", "E").delayElements(Duration.ofSeconds(1))
        val  mono = Mono.just("!")

        val fluxC = Flux.concat(fluxA, fluxB, mono)

        StepVerifier.create(fluxC.log())
                .expectNext("P", "A", "D", "O", "V", "E", "S", "E", "!")
                .verifyComplete()
    }

    @Test
    fun combineFlux_withZip(){
        val fluxA = Flux.just("P", "A", "D", "O")
        val fluxB = Flux.just("V", "E", "S", "E")

        val biFunction = BiFunction<String, String, String> { e, f -> e+f }
        val fluxC = Flux.zip(fluxA, fluxB, biFunction)

        StepVerifier.create(fluxC.log())
                .expectNext("PV", "AE", "DS", "OE")
                .verifyComplete()
    }
}