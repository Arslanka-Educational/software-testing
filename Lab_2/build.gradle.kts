
plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.assertj:assertj-core:3.11.0")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.1.0")
    testImplementation("org.testng:testng:7.1.0")
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}