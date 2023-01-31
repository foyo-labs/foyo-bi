import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
}

repositories {
  mavenCentral()
}

dependencies {
  // kotlin support
//  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}


description = "foyo-bi-ignite"

