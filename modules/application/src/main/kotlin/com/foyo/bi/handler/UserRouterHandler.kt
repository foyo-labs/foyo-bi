package com.foyo.bi.handler

import com.foyo.bi.service.UserService
import org.slf4j.LoggerFactory
class UserRouterHandler(val service: UserService) {
  private val logger = LoggerFactory.getLogger(UserRouterHandler::class.java)

}
