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
                implementation(compose.web.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                implementation(libs.kobwebx.markdown)
             }
        }
    }
}