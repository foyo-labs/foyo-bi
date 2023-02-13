package com.foyo.bi.router

import com.foyo.bi.entity.User
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.usersRoutes() {
    route("/users") {
        get{
            call.respond(User(1, "kotlin"))
        }
    }
}