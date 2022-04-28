plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
    maven {
        url = uri("https://maven.pkg.github.com/bitPogo/kmock")
        credentials {
            username = project.findProperty("gpr.user") as? String
                ?: System.getenv("GITHUB_USER")
            password = project.findProperty("gpr.key") as? String
                ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation("tech.antibytes.kmock:kmock-gradle:0.1.1")
}
