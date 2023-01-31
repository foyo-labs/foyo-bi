package com.foyo.bi.service

import com.foyo.bi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repo: UserRepository) {
  suspend fun findAll() = repo.findAll()
}
