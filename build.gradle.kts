@file:Suppress("SpellCheckingInspection")

plugins {
    java
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.13"
//    id("jacoco")
}

java {
    modularity.inferModulePath.set(true)
}

application {
    mainModule.set(moduleName)
//    mainClass.set("cl.uchile.dcc.finalreality.gui.FinalReality")
}

group = "cl.uchile.dcc"
version = "2.0-RELEASE"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx:18.0.2:pom")
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

javafx {
    version = "14-ea+6"
    modules = mutableListOf("javafx.controls")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}