package br.com.hortifrete.server.repository

import br.com.hortifrete.server.model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, String>