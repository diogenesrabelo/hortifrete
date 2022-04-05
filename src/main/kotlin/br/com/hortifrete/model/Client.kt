package br.com.hortifrete.model

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
    var activated: Boolean = true,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    var updatedAt: LocalDateTime = LocalDateTime.now()
)

data class Endereco(
    var cep: String,
    var rua: String,
    var numero: Int,
    var complemento: String?,
    var bairro: String,
    var cidade: String,
    var estado: String
)
