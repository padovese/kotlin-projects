package com.github.padovese.reactiveproject.fluxandmonoplayground

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import java.time.Duration


class ColdAndHotPublisher {

    @Test
    fun coldPublisher() {
        val flux = Flux.just("P", "A", "D", "O", "V", "E", "S", "E").delayElements(Duration.ofSeconds(1))

        flux.subscribe { e -> println("subscriber 1: $e") }
        Thread.sleep(2000)

        flux.subscribe { e -> println("subscriber 2: $e") }
        Thread.sleep(4000)

        //this flow is async, take the elements away from beginning
    }

    @Test
    fun hostPublisher() {
        val flux = Flux.just("P", "A", "D", "O", "V", "E", "S", "E").delayElements(Duration.ofSeconds(1))

        val connectableFlux = flux.publish()
        connectableFlux.connect()

        connectableFlux.subscribe { e -> println("subscriber 1: $e") }
        Thread.sleep(3000)

        connectableFlux.subscribe { e -> println("subscriber 2: $e") }
        Thread.sleep(4000)

        //this flow continues respecting the actual value position

    }
}