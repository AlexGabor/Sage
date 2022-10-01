// Enable Gradle's version catalog support
// https://docs.gradle.org/current/userguide/platforms.html
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}
rootProject.name = "Sage"
include(":web")
include(":kobweb")
include(":android")
include(":common")
include(":ui")