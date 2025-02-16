/*
 * Copyright (c) 2021 Touchlab
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

buildscript {
    extra["kotlin_plugin_id"] = "co.touchlab.cklib"
    dependencies {
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.25.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    }
}

plugins {
    id("com.github.gmazzo.buildconfig") version "4.1.2" apply false
}

val GROUP: String by project
val CKLIB_VERSION: String by project

allprojects {
    group = GROUP
    version = CKLIB_VERSION
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven("https://plugins.gradle.org/m2/")
    }
}
