plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version "0.5.0-build235"
}


repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    mavenCentral()
}

kotlin {
    android()
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines)
                implementation(compose.runtime)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.web.widgets)
                implementation(compose.runtime)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
            }

        }
    }
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 23
        targetSdk = 30
    }

    configurations {
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.srcDirs("src/androidMain/kotlin")
            res.srcDirs("src/androidMain/res")
        }
    }
}