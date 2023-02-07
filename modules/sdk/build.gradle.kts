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
  implementation(libs.dataframe)
  implementation(libs.arrow.memory)
  implementation(libs.arrow.vector)
  implementation(libs.calcite.core)
  testImplementation(libs.junit)
}

description = "foyo-bi-sdk"

