package com.foyo.bi

import com.foyo.bi.router.configureRouting
import io.ktor.server.application.*
import io.ktor.server.netty.*

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*

fun main(args: Array<String>): Unit = EngineMain.main(args)


fun Application.module() {
  configureRouting()
  configureSerialization()
}

fun Application.configureSerialization() {
  install(ContentNegotiation) {
    json()
  }
}