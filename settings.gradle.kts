// Enable Gradle's version catalog support
// https://docs.gradle.org/current/userguide/platforms.html
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "Sage"
include(":web")
include(":android")
include(":common")
include(":ui")