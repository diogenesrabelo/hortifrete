package br.com.hortifrete.server.repository

import br.com.hortifrete.server.model.Client
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: MongoRepository<Client, String>