package br.com.hortifrete.server.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("client")
class ClientController {

    @PostMapping("/")
    fun createClient(): ResponseEntity<Any> {
        return try {
            ResponseEntity("Criado", HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/")
    fun getClients(): ResponseEntity<Any> {
        return try {
            ResponseEntity("Client", HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/{id}")
    fun getClients(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            ResponseEntity("Client", HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updateClient(
        @PathVariable("id") id: String,
        @RequestBody client: Any
    ): ResponseEntity<Any> {
        return try {
            ResponseEntity("Client", HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun disableClient(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            ResponseEntity("Disable Client", HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun activatedClient(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            ResponseEntity("Disable Client", HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }
}