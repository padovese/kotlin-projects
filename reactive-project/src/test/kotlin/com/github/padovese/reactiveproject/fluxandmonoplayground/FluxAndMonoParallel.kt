package com.github.padovese.reactiveproject.fluxandmonoplayground

import javafx.application.Application.launch
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers.parallel
import reactor.test.StepVerifier


class FluxAndMonoParallel {

    private val flux = Flux.just("ClientOne")
    private val fluxWithManyElements = Flux.just("ClientOne", "ClienTwo", "ClientThree", "ClientFour")

    @Test
    fun flatMapWithFlux() {

        val productFlux = flux.flatMap { e -> clientService_getProducts(e) } //flatmap is ideal to external services, db calls, eand others that can return a flux, tc
                .log()

        StepVerifier.create(productFlux)
                .expectNextCount(4)
                .verifyComplete()


    }

    private fun clientService_getProducts(e: String): Flux<String> {
        Thread.sleep(3000)
        return Flux.just(e, "Product 1", "Product 2", "Product 3")
    }

    @Test
    fun parallelFlux() {

        //it takes 12 seconds sequentially. In parallel takes 1.

        val productFlux = fluxWithManyElements
                .window(1)
                .flatMap { e ->
                    e.map { e -> clientService_getProducts(e) }
                            .subscribeOn(parallel())
                            .flatMap { s -> s }
                }
                .log()

        StepVerifier.create(productFlux)
                .expectNextCount(16)
                .verifyComplete()
    }

}
