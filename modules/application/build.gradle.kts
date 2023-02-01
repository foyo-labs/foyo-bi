plugins {
  id("org.springframework.boot") version "2.7.8"
  id("io.spring.dependency-management") version "1.0.15.RELEASE"
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
}

val igniteVersion = "3.0.0-beta1"

dependencies {

  // Spring
  implementation("org.springframework.boot:spring-boot-starter-webflux")

  //ignite
  implementation("org.apache.ignite:ignite-api:$igniteVersion")
  implementation("org.apache.ignite:ignite-client:$igniteVersion")

  // development stage support
  developmentOnly("org.springframework.boot:spring-boot-devtools")

  // Data
  implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")
  runtimeOnly("io.r2dbc:r2dbc-postgresql")
  runtimeOnly("org.postgresql:postgresql")
  implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

  implementation(project(":foyo-bi-ignite"))

  // Test
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

description = "foyo-bi-app"
