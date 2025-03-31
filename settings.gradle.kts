pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = java.net.URI("https://jitpack.io") }
        resolutionStrategy {
            eachPlugin {
                if (requested.id.id == "com.hyperdevs.poeditor") {
                    useModule("com.github.hyperdevs-team:poeditor-android-gradle-plugin:${requested.version}")
                }
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "TTcomponents"

include(":app")
include(":components")
include(":shared-domain")
include(":astro-components")