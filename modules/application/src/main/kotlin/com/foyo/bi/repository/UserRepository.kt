package com.foyo.bi.repository

import com.foyo.bi.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Flux

interface UserRepository: CoroutineCrudRepository<User, Int>{

  fun findByName(name: String): Flux<User>
}

