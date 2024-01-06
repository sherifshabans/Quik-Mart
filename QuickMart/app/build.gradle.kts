plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.8.10"




}

android {
    namespace = "com.example.quickmart"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quickmart"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }/*
    buildscript {
        repositories {
            google()
        }
        dependencies {
            val nav_version = "2.7.4"
            classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        }
    }*/
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.foundation:foundation-android:1.5.3")
    implementation("com.google.firebase:firebase-inappmessaging-ktx:20.3.5")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //    kotlin serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    implementation ("com.google.code.gson:gson:2.10.1")


    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.4")
    implementation ("androidx.compose.ui:ui:1.5.3")
    implementation ("androidx.compose.material:material:1.5.3")
    implementation ("androidx.activity:activity-compose:1.8.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0-alpha02")

    val composeBom = platform("androidx.compose:compose-bom:2023.10.00")
    implementation(composeBom)

    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")



    implementation ("io.coil-kt:coil-compose:1.4.0")  // Use the latest version


   // implementation ("com.google.accompanist:accompanist-coil:0.18.0")




    val nav_version = "2.7.4"

            // Java language implementation
            implementation("androidx.navigation:navigation-fragment:$nav_version")
            implementation("androidx.navigation:navigation-ui:$nav_version")

            // Kotlin
            implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
            implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

            // Feature module Support
            implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

            // Testing Navigation
            androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

            // Jetpack Compose Integration
            implementation("androidx.navigation:navigation-compose:$nav_version")




}