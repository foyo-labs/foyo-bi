import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.8.0"
}


allprojects {
  apply(plugin = "kotlin")
  repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
  }

}

allprojects {

  group = "com.foyolabd"
  version = "0.0.1-SNAPSHOT"
  java.sourceCompatibility = JavaVersion.VERSION_11

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }

  tasks.withType<Test>().configureEach {
    useJUnitPlatform()
  }
}

subprojects{
  dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  }
}
