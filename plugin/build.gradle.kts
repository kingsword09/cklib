import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-gradle-plugin")
  kotlin("jvm")
  id("com.github.gmazzo.buildconfig")
  id("com.vanniktech.maven.publish")
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

val KOTLIN_VERSION: String by project

dependencies {
  implementation(gradleApi())
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION")
  implementation("org.rauschig:jarchivelib:1.2.0")
  implementation(kotlin("stdlib-jdk8"))
}

buildConfig {
  packageName("co.touchlab.cklib.gradle")
  buildConfigField("String", "KOTLIN_PLUGIN_ID", "\"${rootProject.extra["kotlin_plugin_id"]}\"")
  buildConfigField("String", "KOTLIN_PLUGIN_GROUP", "\"${project.group}\"")
  buildConfigField("String", "KOTLIN_PLUGIN_NAME", "\"${project.name}\"")
  buildConfigField("String", "KOTLIN_PLUGIN_VERSION", "\"${project.version}\"")
}

gradlePlugin {
  plugins {
    create("cklibPlugin") {
      id = rootProject.extra["kotlin_plugin_id"] as String
      displayName = "CKlib Gradle Plugin"
      description = "CKlib Gradle Plugin"
      implementationClass = "co.touchlab.cklib.gradle.CompileToBitcodePlugin"
    }
  }
}
repositories {
  mavenCentral()
  maven("https://plugins.gradle.org/m2/")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "17"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "17"
}