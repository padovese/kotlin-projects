package com.github.padovese.reactiveproject.fluxandmonoplayground

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier


class FluxAndMonoTransformTest {

    private val flux = Flux.just("Pa", "do", "ve", "se")

    @Test
    fun testFluxToUpperCase(){
        val upperFlux = flux.map { e -> e.toUpperCase() }
                .log()

        StepVerifier.create(upperFlux)
                .expectNext("PA")
                .expectNext("DO")
                .expectNext("VE")
                .expectNext("SE")
                .verifyComplete()
    }

    @Test
    fun testFluxLength(){
        val lengthFlux = flux.map { e -> e.length }
                .log()

        StepVerifier.create(lengthFlux)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .verifyComplete()
    }

    @Test
    fun testRepeatingTheFlux(){
        val repeatFlux = flux.map { e -> e.length }
                .repeat(1)
                .log()

        StepVerifier.create(repeatFlux)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .expectNext(2)
                .verifyComplete()
    }
}