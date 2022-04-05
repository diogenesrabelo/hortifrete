package br.com.hortifrete.model

import org.springframework.data.annotation.Id
import java.math.BigDecimal
import java.time.LocalDateTime

data class Sale(
    @Id
    val id: String,

    val product: Product,

    val client: Client,

    val quantidade: Long,

    val total: BigDecimal,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
