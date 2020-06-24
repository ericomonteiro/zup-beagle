package br.com.ericocm.bff

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BffBeagleApplication

fun main(args: Array<String>) {
	runApplication<BffBeagleApplication>(*args)
}
