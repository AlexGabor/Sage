// Add compose gradle plugin
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "0.5.0-build235"
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
                implementation(project(":commonUi"))
                implementation(compose.web.core)
                implementation(compose.web.widgets)
                implementation(compose.runtime)
            }
        }
    }
}

tasks.register<Copy>("build404page") {
    dependsOn("build")
    from(layout.buildDirectory.file("distributions/index.html"))
    rename("index.html", "distributions/404.html")
    into(layout.buildDirectory)
}

tasks.register<Copy>("buildGhPages") {
    dependsOn("build404page")
    mkdir(layout.buildDirectory.dir("ghPages"))
    from(layout.buildDirectory.dir("distributions"))
    exclude("**/*.map")
    into(layout.buildDirectory.dir("ghPages"))
}

task("wrapper") // TODO why?