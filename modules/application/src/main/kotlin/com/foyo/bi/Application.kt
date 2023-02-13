package com.foyo.bi

import com.foyo.bi.db.DatabaseFactory
import com.foyo.bi.di.databaseModule
import com.foyo.bi.router.configureRouting
import io.ktor.server.application.*
import io.ktor.server.netty.*

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import org.koin.core.context.startKoin
import org.koin.ktor.ext.inject

fun main(args: Array<String>): Unit = EngineMain.main(args)


fun Application.module() {
  configureRouting()
  configureSerialization()
  configureKoin()
  configureDatabase()
}

fun Application.configureKoin() {
  startKoin {
    modules(listOf(databaseModule))
  }
}

fun Application.configureDatabase() {
  val dbFactory: DatabaseFactory by inject()
  dbFactory.init()
}

fun Application.configureSerialization() {
  install(ContentNegotiation) {
    json()
  }
}
