package com.github.padovese.reactiveproject.fluxandmonoplayground

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier


class FluxAndMonoBackPressure {

    @Test
    fun backPressure() {
        val flux = Flux.range(1, 20)

        StepVerifier.create(flux)
                .expectSubscription()
                .thenRequest(1)
                .expectNext(1)
                .thenRequest(1)
                .expectNext(2)
                .thenRequest(1)
                .expectNext(3)
                .thenCancel()
                .verify()

        //It control the flow and can take an action between Flux signals

    }

    @Test
    fun backPressure_otherTest() {
        val flux = Flux.range(1, 20)

        flux.subscribe({ e -> println("Element: $e") },
                { f -> println("Exception: $f") },
                {println("Completed.")},
                {g -> g.request(5)})

    }
}