package com.foyo.bi.db

import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.component.KoinComponent

class DatabaseFactory(private val dataSource: HikariDataSource) : KoinComponent {
  fun init() {
    Database.connect(dataSource)
    transaction {
//      SchemaUtils.create(UserTable)
    }
  }

  suspend fun <T> dbQuery(block: () -> T): T =
    withContext(Dispatchers.IO) {
      transaction { block() }
    }
}
