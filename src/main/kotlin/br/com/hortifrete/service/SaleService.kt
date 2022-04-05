package br.com.hortifrete.service

import br.com.hortifrete.configuration.unwrap
import br.com.hortifrete.model.Sale
import br.com.hortifrete.repository.SaleRepository
import org.springframework.stereotype.Service

@Service
class SaleService(
    private val saleRepository: SaleRepository
) {

    fun createSale(sale: Sale): Sale {
        return try {
            saleRepository.insert(sale)
        } catch (ex: Exception) {
            throw Exception("Não foi possível criar a venda")
        }
    }

    fun getSale(id: String): Sale? {
        return try {
            saleRepository.findById(id).unwrap()
        } catch (ex: Exception) {
            throw Exception("Não foi possível recuperar a venda")
        }
    }

    fun getSales(): List<Sale> {
        return try {
            saleRepository.findAll()
        } catch (ex: Exception) {
            throw Exception("Não foi possível recuperar todas as vendas")
        }
    }

    fun deleteSale(sale: Sale) {
        return try {
            saleRepository.delete(sale)
        } catch (ex: Exception) {
            throw Exception("Não foi possível deletar a venda")
        }
    }
}