package com.github.padovese.reactiveproject.fluxandmonoplayground

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.lang.RuntimeException


class FlluxAndMonoTest {

    @Test
    fun fluxTest() {

        val flux = Flux.just("Pa", "do", "ve", "se")

        flux.subscribe { e -> println(e) }
        flux.subscribe { println(it) }
    }

    @Test
    fun generatingFlux() {
        val arr = arrayOf("Pa", "do", "ve", "se")
        val flux = Flux.fromArray(arr)

        flux.subscribe { print(it) }

        flux.subscribe({ print(it) },             //onNext
                { println("Error: $it") },        //onError
                { println("Completed.") })        //onComplete

        //subscribe doesn't remove the elements from the flux.
    }

    @Test
    fun intervalFlux() {
        val flux = Flux.just("a", "b", "c", 1, 10L)
                .concatWith (Flux.error<RuntimeException>(RuntimeException("Forcing error.")) )
                //.log()

        flux.subscribe({ println(it) },
                        { println(it) }) //handle the exception, similar to catch

        println("---")

        flux.subscribe{ println(it) }  //break the code

        //whenever an error occurs, the flux doesn't continue.
    }

    @Test
    fun testFlux_withNoError(){
        val flux = Flux.just("Pa", "do", "ve", "se").log()

        StepVerifier.create(flux)
                .expectNext("Pa")
                .expectNext("do")
                .expectNext("ve")
                .expectNext("se")
                .verifyComplete()
    }

    @Test
    fun testFlux_withError(){
        val flux = Flux.just("Pa", "do", "ve", "se", 1)
                .concatWith (Flux.error<RuntimeException>(RuntimeException("Forcing error.")) )
                .log()

        StepVerifier.create(flux)
                .expectNext("Pa")
                .expectNext("do")
                .expectNext("ve")
                .expectNext("se")
                .expectNext(1)
                .expectError(RuntimeException::class.java)
                //.expectErrorMessage("Forcing error.")

    }

    @Test
    fun testFlux_countWithError(){
        val flux = Flux.just("Pa", "do", "ve", "se", 1)
                .concatWith (Flux.error<RuntimeException>(RuntimeException("Forcing error.")) )
                .log()

        StepVerifier.create(flux)
                .expectNextCount(5)
                .expectError(RuntimeException::class.java)
        //.expectErrorMessage("Forcing error.")

    }

    @Test
    fun testMono(){
        val mono = Mono.just("Padovese")

        StepVerifier.create(mono)
                .expectNext("Padovese")
                .verifyComplete()
    }
}