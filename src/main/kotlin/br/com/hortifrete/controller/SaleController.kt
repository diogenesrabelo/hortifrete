package br.com.hortifrete.controller

import br.com.hortifrete.model.Sale
import br.com.hortifrete.service.SaleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("sale")
class SaleController(
    private val saleService: SaleService
) {

    @PostMapping("/")
    fun createSale(@RequestBody sale: Sale): ResponseEntity<Any> {
        return try {
            val saleResponse = saleService.createSale(sale)
            ResponseEntity(saleResponse, HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/")
    fun getSales(): ResponseEntity<Any> {
        return try {
            val salesResponse = saleService.getSales()
            ResponseEntity(salesResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun getSale(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            val saleResponse = saleService.getSale(id)
            ResponseEntity(saleResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteSales(@PathVariable("id") id: String,
                    @RequestBody sale: Sale): ResponseEntity<Any> {
        return try {
            val saleResponse = saleService.deleteSale(id, sale)
            ResponseEntity(saleResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}