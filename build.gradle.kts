import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.foyolabd"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val igniteVersion = "3.0.0-beta1"

repositories {
	mavenCentral()
}

dependencies {

  // Spring
	implementation("org.springframework.boot:spring-boot-starter-webflux")

  // kotlin support
  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  //ignite
	implementation("org.apache.ignite:ignite-core:$igniteVersion")

  // development stage support
  developmentOnly("org.springframework.boot:spring-boot-devtools")

  // Data
  implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")
  runtimeOnly("io.r2dbc:r2dbc-postgresql")
  runtimeOnly("org.postgresql:postgresql")
  implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

  // Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
