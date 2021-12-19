plugins {
    kotlin("jvm") version libs.versions.kotlin
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of("11"))
    }
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform {
            includeEngines("junit-jupiter")
        }
    }
}

dependencies {
    testImplementation(libs.guava)
    testImplementation(testLibs.bundles.junit.implementation)
    testImplementation(testLibs.strikt.core)
    testRuntimeOnly(testLibs.bundles.junit.runtime)
}


tasks {
    wrapper {
        gradleVersion = "7.3.2"
    }
}
