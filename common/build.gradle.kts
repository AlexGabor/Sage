plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

repositories {
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
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
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