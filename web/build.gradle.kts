// Add compose gradle plugin
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "0.0.0-web-dev-11"
}

// Add maven repositories
repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    mavenCentral()
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.web.web)
                implementation(compose.runtime)
            }
        }
    }
}

task("wrapper") // TODO why?