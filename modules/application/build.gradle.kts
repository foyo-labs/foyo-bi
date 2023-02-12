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
  implementation(libs.logback)

//  runtimeOnly("org.postgresql:postgresql")

  // MySQL/Mariadb
  implementation(libs.mysql)

  // Kotlin Dataframe
  implementation(libs.dataframe)

  implementation(project(":foyo-bi-sdk"))

  testImplementation(libs.kotest.core)
}

description = "foyo-bi-app"
