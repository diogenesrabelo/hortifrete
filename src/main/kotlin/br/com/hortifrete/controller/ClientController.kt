package br.com.hortifrete.controller

import br.com.hortifrete.model.Client
import br.com.hortifrete.service.ClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("client")
class ClientController(
    private val clientService: ClientService
) {

    companion object {
        const val DISABLE = false
        const val ACTIVATE = true
    }

    @PostMapping("/")
    fun createClient(@RequestBody client: Client): ResponseEntity<Any> {
        return try {
            val clientResponse = clientService.createClient(client)
            ResponseEntity(clientResponse, HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/")
    fun getClients(): ResponseEntity<Any> {
        return try {
            val clients = clientService.getClients()
            ResponseEntity(clients, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/{id}")
    fun getClients(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            val clientResponse = clientService.getClient(id)
            ResponseEntity(clientResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updateClient(
        @PathVariable("id") id: String,
        @RequestBody client: Client
    ): ResponseEntity<Any> {
        return try {
            val updatedClient = clientService.updateClient(id, client)
            ResponseEntity(updatedClient, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/disable/{id}")
    fun disableClient(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            clientService.changeClientStatus(id, DISABLE)
            ResponseEntity("Cliente desativado!", HttpStatus.NO_CONTENT)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/activate/{id}")
    fun activatedClient(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            clientService.changeClientStatus(id, ACTIVATE)
            ResponseEntity("Cliente Reativado!", HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.NOT_FOUND)
        }
    }
}