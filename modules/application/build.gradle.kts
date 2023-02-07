plugins {
  id("org.springframework.boot") version "2.7.8"
  id("io.spring.dependency-management") version "1.0.15.RELEASE"
  kotlin("jvm") version "1.8.0"
  kotlin("plugin.spring") version "1.6.21"
}

dependencies {

  // Spring
  implementation("org.springframework.boot:spring-boot-starter-webflux")

  // development stage support
  developmentOnly("org.springframework.boot:spring-boot-devtools")

  // Data
  implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")
  runtimeOnly("io.r2dbc:r2dbc-postgresql")
  runtimeOnly("org.postgresql:postgresql")
  implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

  // MySQL/Mariadb
  implementation(libs.mysql)

  // Kotlin Dataframe
  implementation(libs.dataframe)

  // Test
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

description = "foyo-bi-app"
