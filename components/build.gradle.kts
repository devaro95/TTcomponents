plugins {
    id("maven-publish")
    id("com.android.library")
    alias(libs.plugins.jetbrains.android)
    alias(libs.plugins.compose.compiler)
    id("com.hyperdevs.poeditor")
}

android {
    namespace = "com.ttcomponents.app"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
    buildFeatures {
        compose = true
    }
    poEditor {
        apiToken.set("32c8779b738efb9cd3a3aa959fe3ecbf")
        projectId.set(677693)
        defaultLang.set("es")
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.devaro95"
            version = "0.0.1"
            artifactId = "tt-components"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation(project(":shared-domain"))

    implementation(platform(libs.firebase.bom))
    implementation(libs.vro.compose)
    implementation(libs.vro.common)
    implementation(libs.core.ktx)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.material3.icons)
    implementation(libs.material3.icons.extended)
    implementation(libs.runtime)
    implementation(libs.runtime.livedata)
    implementation(libs.glide)
    implementation(libs.coil)
    implementation(libs.kotlin.immutable)
    implementation(libs.pager.indicator)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}