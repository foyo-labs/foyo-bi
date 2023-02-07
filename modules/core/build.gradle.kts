plugins {
  id("org.springframework.boot") version "2.7.8"
  id("io.spring.dependency-management") version "1.0.15.RELEASE"
  kotlin("jvm") version "1.8.0"
  kotlin("plugin.spring") version "1.6.21"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.arrow.vector)
  implementation(libs.arrow.format)
  implementation(libs.arrow.memory)
  implementation(libs.arrow.jdbc)
  implementation(libs.calcite.core)
  implementation(libs.calcite.csv)
  implementation(libs.logging)
  implementation("org.postgresql:postgresql")
  implementation("ch.qos.logback:logback-classic:1.2.3")
  implementation("org.slf4j:slf4j-api:1.7.30")
  testImplementation(libs.kotest.core)
  testImplementation(libs.kotest.junit5)
}


description = "foyo-bi-core"

