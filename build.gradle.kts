buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            url = java.net.URI("https://raw.github.com/bitPogo/maven-snapshots/main/snapshots")
            content {
                includeGroup("tech.antibytes.kmock")
            }
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("tech.antibytes.kmock:kmock-gradle:0.1.1-SNAPSHOT")
    }
}

plugins {
    id("com.google.devtools.ksp") version "1.6.21-1.0.5"
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = java.net.URI("https://raw.github.com/bitPogo/maven-snapshots/main/snapshots")
            content {
                includeGroup("tech.antibytes.kmock")
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
