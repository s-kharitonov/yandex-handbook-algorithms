plugins {
    id("io.spring.dependency-management") apply(false)
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    configurations.all {
        resolutionStrategy.failOnVersionConflict()
    }
}