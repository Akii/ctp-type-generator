pluginManagement {
    plugins {
        kotlin("jvm") version "1.7.20"
        id("org.jetbrains.dokka") version "1.7.20"
        id("com.gradle.plugin-publish") version "1.0.0"
        id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    }
}

rootProject.name = "commercetools-sdk-java-v2-custom-types"

include(":commercetools-sdk-java-api-customtypes-generator")
include(":commercetools-sdk-java-api-customtypes-gradle-plugin")

project(":commercetools-sdk-java-api-customtypes-generator").projectDir = file("commercetools-sdk-java-api-customtypes-generator")
project(":commercetools-sdk-java-api-customtypes-gradle-plugin").projectDir = file("commercetools-sdk-java-api-customtypes-gradle-plugin")
