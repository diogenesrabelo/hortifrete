package br.com.hortifrete

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class ServerApplication

fun main(args: Array<String>) {
	runApplication<ServerApplication>(*args)
}
