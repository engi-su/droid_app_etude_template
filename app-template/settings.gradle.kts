@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("../build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal() //for dependency like org.jlleitschuh.gradle.ktlint
    }
    versionCatalogs {
        create("libs") {
            from(files("../build-logic/gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "app-template"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
