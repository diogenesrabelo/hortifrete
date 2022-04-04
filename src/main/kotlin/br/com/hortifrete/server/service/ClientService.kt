package br.com.hortifrete.server.service

import br.com.hortifrete.server.configuration.unwrap
import br.com.hortifrete.server.model.Client
import br.com.hortifrete.server.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository
) {

    fun createClient(client: Client): Client {
        return try {
            clientRepository.insert(client)
        } catch (ex: Exception) {
            throw Exception("Erro ao inserir novo cliente!")
        }
    }

    fun getClient(id: String): Client? {
        return try {
            clientRepository.findById(id).unwrap()
        } catch (ex: Exception) {
            throw Exception("Cliente não encontrado")
        }
    }

    fun getClients(): List<Client>? {
        return try {
            clientRepository.findAll()
        } catch (ex: Exception) {
            throw Exception("Cliente não encontrado")
        }
    }

    fun updateClient(id: String, client: Client): Client {
        return try {
            clientRepository.insert(client)
        } catch (ex: Exception) {
            throw Exception("Cliente não encontrado")
        }
    }

    fun changeClientStatus(id: String, status: Boolean): Client {
        return try {
            val client = clientRepository.findById(id).unwrap()
            client!!.activated = status
            clientRepository.insert(client)
        } catch (ex: Exception) {
            throw Exception("Cliente não encontrado")
        }
    }
}