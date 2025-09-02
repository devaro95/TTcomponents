plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
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
        sourceCompatibility = JavaVersion.VERSION_22
        targetCompatibility = JavaVersion.VERSION_22
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_22.toString()
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":components"))

    implementation(libs.vro.compose)
    implementation(libs.material3)
    implementation(libs.material3.icons)
    implementation(libs.material3.icons.extended)
    implementation(libs.runtime)
    implementation(libs.koin.compose)
    implementation(libs.koin.annotations)
    ksp(libs.koin.compiler)
}