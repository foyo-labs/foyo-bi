package com.foyo.bi

import com.foyo.bi.router.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
  embeddedServer(Netty, port = 7788, module = Application::module).start(wait = true)
}

fun Application.module() {
  configureRouting()
}