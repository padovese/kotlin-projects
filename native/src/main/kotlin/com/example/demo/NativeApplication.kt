package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NativeApplication

fun main(args: Array<String>) {
	runApplication<NativeApplication>(*args)
}
