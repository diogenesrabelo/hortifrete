package br.com.hortifrete.service

import br.com.hortifrete.configuration.unwrap
import br.com.hortifrete.model.Historico
import br.com.hortifrete.model.Product
import br.com.hortifrete.repository.ProductRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun createProduct(product: Product): Product {
        return try {
            productRepository.insert(product)
        } catch (ex: Exception) {
            throw Exception("Erro ao inserir novo produto")
        }
    }

    fun getProducts(): List<Product> {
        return try {
            productRepository.findAll()
        } catch (ex: Exception) {
            throw Exception("Erro ao buscar todos os produtos")
        }
    }

    fun getProduct(id: String): Product? {
        return try {
            productRepository.findById(id).unwrap()
        } catch (ex: Exception) {
            throw Exception("Erro ao buscar todos os produtos")
        }
    }

    fun updateProduct(id: String, product: Product): Product? {
        return try {
            productRepository.findById(id).unwrap()
        } catch (ex: Exception) {
            throw Exception("Erro ao inserir novo produto")
        }
    }

    private fun createProductHistoric(productOld: Product, productNew: Product): Product {
        if(verifyProductsEquals(productOld, productNew)){
            val historic: Historico = Historico(productOld.valor, LocalDateTime.now())
            if(productNew.historico.isNullOrEmpty()) {
                productNew.historico = mutableListOf(historic)
            } else {
                productNew.historico?.add(historic)
            }
            return productNew
        } else {
            throw Exception("Tentativa de atualizar o objeto diferente!")
        }

    }

    private fun verifyProductsEquals(productOld: Product, productNew: Product): Boolean {
        return productOld.id == productNew.id
    }

}