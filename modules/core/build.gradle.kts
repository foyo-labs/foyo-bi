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
  implementation(libs.calcite)
  runtimeOnly("org.postgresql:postgresql")

  implementation(project(":foyo-bi-sdk"))
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}


description = "foyo-bi-core"

