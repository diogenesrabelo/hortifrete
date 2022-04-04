package br.com.hortifrete.server.configuration

import java.util.*

fun <T> Optional<T>.unwrap(): T? = orElse(null)