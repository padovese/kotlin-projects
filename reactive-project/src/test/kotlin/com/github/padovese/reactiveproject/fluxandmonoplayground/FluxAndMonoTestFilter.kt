package com.github.padovese.reactiveproject.fluxandmonoplayground

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier


class FluxAndMonoTestFilter {

    val flux = Flux.just("Pa", "do", "ve", "se")

    @Test
    fun testNameFilter(){
        val nameFlux = flux.filter { e -> e.endsWith("e") }
                .log()

        StepVerifier.create(nameFlux)
                .expectNext("ve")
                .expectNext("se")
                .verifyComplete()
    }

    @Test
    fun testLengthFilter(){
        val nameFlux = flux. filter { e -> e.length == 2 }
                .log()

        StepVerifier.create(nameFlux)
                .expectNext("Pa")
                .expectNext("do")
                .expectNext("ve")
                .expectNext("se")
                .verifyComplete()
    }
}