plugins {
    kotlin("jvm") version "2.1.21"
    id("com.netflix.dgs.codegen") version "8.1.0"
}

group = "com.example.dgscodegeninterfaces"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.3")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.generateJava {
    schemaPaths = mutableListOf("${projectDir}/src/main/resources/schema") // List of directories containing schema files
    packageName = "com.example.dgscodegeninterfaces.generated" // The package name to use to generate sources
    generateClient = true // Enable generating the type safe query API
    generateDataTypes = true
}
