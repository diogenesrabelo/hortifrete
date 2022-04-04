package br.com.hortifrete.server.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "product")
data class Product(
    @Id
    val id: String,

    val nome: String,

    var valor: BigDecimal,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    var updatedAt: LocalDateTime = LocalDateTime.now(),

    val historico: List<Historico>?
)

data class Historico(
    val valor: BigDecimal,
    val createdAt: LocalDateTime
)
