import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
}

android {
    namespace = "com.example.tt_components"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tt_components"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    detekt {
        toolVersion = "1.23.8" // Misma versión que el plugin
        config = files("../detekt.yml")
        buildUponDefaultConfig = true
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "21" // or "21" depending on your needs
        }
    }
    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        jvmTarget = "21" // or "21"
    }
}

dependencies {
    implementation(project(":components"))
    implementation(project(":astro-components"))
    implementation(project(":shared-domain"))

    implementation(libs.vro.compose)
    implementation(libs.vro.common)
    implementation(libs.material3)
    implementation(libs.material3.icons)
    implementation(libs.material3.icons.extended)
    implementation(libs.runtime)
    implementation(libs.koin.compose)
    implementation(libs.koin.annotations)
    implementation(libs.compose.colorpicker)
    implementation(libs.kotlin.immutable)
    ksp(libs.koin.compiler)
}