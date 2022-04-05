package br.com.hortifrete.configuration

import java.util.*

fun <T> Optional<T>.unwrap(): T? = orElse(null)