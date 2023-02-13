plugins {
  application
  id("io.ktor.plugin") version "2.2.3"
  id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
  kotlin("jvm") version "1.8.0"
}

application {
  mainClass.set("io.ktor.server.netty.EngineMain")
}


dependencies {

  implementation(libs.ktor.core)
  implementation(libs.ktor.netty)
  implementation(libs.ktor.negotiation)
  implementation(libs.ktor.json)
  implementation(libs.koin.core)
  implementation(libs.logback)
  implementation(libs.exposed.core)
  implementation(libs.exposed.dao)
  implementation(libs.exposed.javatime)
  implementation(libs.exposed.jodatime)
  implementation(libs.exposed.jdbc)
  implementation(libs.postgres)
  implementation(libs.hikari.cp)
  // MySQL/Mariadb
  implementation(libs.mysql)

  // Kotlin Dataframe
  implementation(libs.dataframe)

  implementation(project(":foyo-bi-sdk"))

  testImplementation(libs.kotest.core)
}

description = "foyo-bi-app"
