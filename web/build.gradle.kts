// Add compose gradle plugin
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.1.0"
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
    sourceSets.all {
        languageSettings.optIn("org.jetbrains.compose.common.ui.ExperimentalComposeWebWidgetsApi")
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(project(":commonUi"))
                implementation(compose.web.core)
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

// https://youtrack.jetbrains.com/issue/KT-52776/KJS-Gradle-Webpack-version-update-despite-yarnlock-breaks-KotlinJS-build
// https://stackoverflow.com/questions/72731436/kotlin-multiplatform-gradle-task-jsrun-gives-error-webpack-cli-typeerror-c/72731728
rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
    versions.webpackCli.version = "4.10.0"
}