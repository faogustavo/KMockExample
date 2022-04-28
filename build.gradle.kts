buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            url = java.net.URI("https://maven.pkg.github.com/bitPogo/kmock")
            credentials {
                username = project.findProperty("gpr.user")?.toString()
                    ?: System.getenv("GITHUB_USER")
                password = project.findProperty("gpr.key")?.toString()
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("tech.antibytes.kmock:kmock-gradle:0.1.1")
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
            url = java.net.URI("https://maven.pkg.github.com/bitPogo/kmock")
            credentials {
                username = project.findProperty("gpr.user")?.toString()
                    ?: System.getenv("GITHUB_USER")
                password = project.findProperty("gpr.key")?.toString()
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
