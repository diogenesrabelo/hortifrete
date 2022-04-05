package br.com.hortifrete.controller

import br.com.hortifrete.model.Product
import br.com.hortifrete.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping("/")
    fun createProduct(@RequestBody product: Product): ResponseEntity<Any> {
        return try {
            val productResponse = productService.createProduct(product)
            ResponseEntity(productResponse, HttpStatus.CREATED)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/")
    fun getProducts(): ResponseEntity<Any> {
        return try {
            val productsResponse = productService.getProducts()
            ResponseEntity(productsResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable("id") id: String): ResponseEntity<Any> {
        return try {
            val productsResponse = productService.getProduct(id)
            ResponseEntity(productsResponse, HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("/{id}")
    fun getProduct(@PathVariable("id") id: String,
                   @RequestBody product: Product
    ): ResponseEntity<Any> {
        return try {
            val productsResponse = productService.updateProduct(id, product)
            ResponseEntity(productsResponse, HttpStatus.NO_CONTENT)
        } catch (ex: Exception) {
            ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}