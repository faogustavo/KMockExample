plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("tech.antibytes.kmock.kmock-gradle") apply false
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js(IR)
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("tech.antibytes.kmock:kmock:0.1.1")
            }
        }

        val mobileMain by creating {
            dependsOn(commonMain)
        }
        val mobileTest by creating {
            dependsOn(commonTest)
        }

        val androidMain by getting {
            dependsOn(mobileMain)
        }
        val androidTest by getting {
            dependsOn(mobileTest)
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(mobileMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(mobileTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}

plugins.apply("tech.antibytes.kmock.kmock-gradle")

project.extensions.configure<tech.antibytes.gradle.kmock.KMockExtension>("kmock") {
    rootPackage = "dev.valvassori.kmockexample"
}
