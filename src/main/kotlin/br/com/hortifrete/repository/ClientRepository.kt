package br.com.hortifrete.repository

import br.com.hortifrete.model.Client
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: MongoRepository<Client, String>