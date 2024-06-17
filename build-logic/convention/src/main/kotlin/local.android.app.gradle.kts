
import components.ComposePlugin
import components.SQAPlugin
import components.TestPlugin
import extensions.library
import extensions.libs
import extensions.version

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply<SQAPlugin>()
apply<TestPlugin>()
apply<ComposePlugin>()

android {
    compileSdk = "compile-sdk".version(libs).toInt()

    defaultConfig {
        minSdk = "min-sdk".version(libs).toInt()
    }

    buildTypes {
        //ToDo PS-71
    }

    compileOptions{
        //ToDo PS-77
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        //ToDo PS-74
        allWarningsAsErrors = true
    }

    packaging {
        //ToDo PS-72
        resources.excludes += setOf(
            "META-INF/AL2.0",
            "META-INF/licenses/**",
            "**/attach_hotspot_windows.dll",
            "META-INF/LGPL2.1",
            "META-INF/LICENSE.md" //from droid
        )
    }
}

kotlin {
    jvmToolchain("java".version(libs).toInt())
}

dependencies {
    //ToDo PS-77
    coreLibraryDesugaring("android-desugar-jdk-libs".library(libs))
}
