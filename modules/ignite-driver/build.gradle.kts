plugins {
  id("org.springframework.boot") version "2.7.8"
  id("io.spring.dependency-management") version "1.0.15.RELEASE"
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
}

val igniteVersion = "3.0.0-beta1"

repositories {
  mavenCentral()
}



dependencies {
  implementation("org.apache.ignite:ignite-api:$igniteVersion")
}


description = "foyo-bi-ignite"

