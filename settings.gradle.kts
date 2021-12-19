rootProject.name = "advent-of-code-2021"

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {

        create("libs") {
            alias("guava").to("com.google.guava:guava:31.0.1-jre")

            version("kotlin", "1.6.10")
        }

        create("testLibs") {
            version("log4j", "2.14.1")
            version("junit.jupiter", "5.8.2")
            version("junit.platform", "1.8.2")
            version("mockk", "1.12.1")
            version("strikt", "0.33.0")

            alias("junit.jupiter.api").to("org.junit.jupiter", "junit-jupiter-api").versionRef("junit.jupiter")
            alias("junit.jupiter.params").to("org.junit.jupiter", "junit-jupiter-params").versionRef("junit.jupiter")
            alias("junit.jupiter.engine").to("org.junit.jupiter", "junit-jupiter-engine").versionRef("junit.jupiter")
            alias("junit.platform.runner").to("org.junit.platform", "junit-platform-runner").versionRef("junit.platform")
            alias("log4j.core").to("org.apache.logging.log4j", "log4j-core").versionRef("log4j")
            alias("log4j.jul").to("org.apache.logging.log4j", "log4j-jul").versionRef("log4j")
            alias("mockk").to("io.mockk", "mockk").versionRef("mockk")
            alias("strikt.core").to("io.strikt", "strikt-core").versionRef("strikt")

            bundle("junit.implementation", listOf("junit.jupiter.api", "junit.jupiter.params"))
            bundle("junit.runtime", listOf("junit.jupiter.engine", "log4j.core", "log4j.jul"))
        }
    }
}