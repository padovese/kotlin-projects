package com.github.padovese.reactiveproject.router

import com.github.padovese.reactiveproject.router.handler.ClubHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router


//@Configuration
class Router(private val clubHandler: ClubHandler) {

  //@Bean
    fun clubRouter() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/", clubHandler::getAllClubs)
            GET("/{id}", clubHandler::getClub)
        }
        POST("/", clubHandler::create)
    }

}