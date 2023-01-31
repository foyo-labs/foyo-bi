package com.foyo.bi.handler

import com.foyo.bi.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class UserRouterHandler(val service: UserService) {
  private val logger = LoggerFactory.getLogger(UserRouterHandler::class.java)

  suspend fun findAll(request: ServerRequest): ServerResponse {
    val users = service.findAll()
    return ok().json().bodyAndAwait(users)
  }
}
