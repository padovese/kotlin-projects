package com.github.padovese.reactiveproject.controller

import com.github.padovese.reactiveproject.service.ClubService
import org.junit.Test

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.kotlin.test.test

@RunWith(SpringRunner::class)
@WebFluxTest
class FluxControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean(name = "clubService")
    private lateinit var clubService: ClubService

    @Test
    fun test1() {
        val flux = webTestClient
                .get()
                .uri("/flux")
                .accept(MediaType.parseMediaType(APPLICATION_STREAM_JSON_VALUE))
                .exchange()
                .expectStatus().isOk
                .returnResult(String::class.java)
                .responseBody


        flux
                .test()
                .expectSubscription()
                .expectNext("Padovese")
                .verifyComplete()
    }

}