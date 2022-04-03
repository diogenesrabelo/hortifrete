package br.com.hortifrete.server.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "client")
data class Client(
    @Id
    val id: String,

    val nome: String,

    val cpf: String,

    val endereco: Endereco,

    @JsonProperty("isActivated")
    val activated: Boolean = true,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    val updatedAt: LocalDateTime = LocalDateTime.now()
)

data class Endereco(
    val cep: String,
    val rua: String,
    val numero: Int,
    val complemento: String?,
    val bairro: String,
    val cidade: String,
    val estado: String
)
