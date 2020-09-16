package com.github.padovese.reactiveproject.fluxandmonoplayground

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.lang.RuntimeException


class FluxAndMonoHandleExceptions {

    @Test
    fun fluxErrorHandle(){
        val flux = Flux.just("P", "A", "D")
                .concatWith(Flux.error(RuntimeException("Padova error.")))
                .concatWith(Flux.just("O", "V", "E", "S", "E"))

        StepVerifier.create(flux.log())
                .expectSubscription()
                .expectError(RuntimeException::class.java)
    }
}