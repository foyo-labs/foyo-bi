package com.foyo.bi.router

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
  routing {
    usersRoutes()
  }
}