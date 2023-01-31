package com.foyo.bi.router

import com.foyo.bi.handler.UserRouterHandler
import org.springframework.web.reactive.function.server.coRouter

fun apiRoutes(userHandler: UserRouterHandler) = coRouter {
  "/api".nest {
    GET("/users", userHandler::findAll)
  }
}
