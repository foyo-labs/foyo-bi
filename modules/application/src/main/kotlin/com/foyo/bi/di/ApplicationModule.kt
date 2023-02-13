package com.foyo.bi.di

import com.foyo.bi.db.DatabaseFactory
import com.foyo.bi.service.UserService
import com.foyo.bi.service.UserServiceImpl
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val applicationModule = module {
  factory { UserServiceImpl() } bind UserService::class
}


val databaseModule = module {
  fun provideHikariDataSource(hikariConfig: HikariConfig) = HikariDataSource(hikariConfig)

  fun provideHikariConfig() = HikariConfig().apply {
    val conf = ConfigFactory.load()
    val host = conf.getString("database.databaseHost")
    val port = conf.getString("database.databasePort")
    val path = conf.getString("database.databasePath")
    val userName = conf.getString("database.databaseUser")
    val password = conf.getString("database.databasePassword")

    driverClassName = System.getenv("JDBC_DRIVER")
    maximumPoolSize = 3
    jdbcUrl = "jdbc:postgresql://$host:$port$path?sslmode=require&user=$userName&password=$password"
    isAutoCommit = false
    transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    validate()
  }

  single { provideHikariDataSource(get()) }
  single { provideHikariConfig() }

  single { DatabaseFactory(get()) }
}
