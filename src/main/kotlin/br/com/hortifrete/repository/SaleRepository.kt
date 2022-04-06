package br.com.hortifrete.repository

import br.com.hortifrete.model.Sale
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository: MongoRepository<Sale, String>