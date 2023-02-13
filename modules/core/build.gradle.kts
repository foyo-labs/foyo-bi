plugins {
  kotlin("jvm") version "1.8.0"
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
//  implementation("org.postgresql:postgresql")

  implementation(project(":foyo-bi-sdk"))
  testImplementation(libs.kotest.core)
  testImplementation(libs.kotest.junit5)
}


description = "foyo-bi-core"

