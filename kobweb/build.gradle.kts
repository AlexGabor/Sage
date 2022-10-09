import kotlinx.html.link
import kotlinx.html.meta

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.1.0"
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
}

group = "com.alexgabor.sage"
version = "1.0-SNAPSHOT"

kobweb {
    index {
        description.set("Powered by Kobweb")
        head.set(listOf {
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
            link(rel = "stylesheet", href = "/root.css")
            link(rel = "preconnect", href = "https://fonts.googleapis.com")
            link(rel = "preconnect", href = "https://fonts.gstatic.com")
            link(
                rel = "stylesheet",
                href = "https://fonts.googleapis.com/css2?family=Mali:ital,wght@0,300;0,500;1,600&display=swap"
            )
        })
    }
}

kotlin {
    js(IR) {
        moduleName = "kobweb"
        browser {
            commonWebpackConfig {
                outputFileName = "kobweb.js"
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":ui"))
                implementation(compose.web.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobwebx.markdown)
            }
        }
    }
}