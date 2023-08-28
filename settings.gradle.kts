pluginManagement {
    val springDependencyManagementVersion: String by settings

    plugins {
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}

dependencyResolutionManagement {
    val junitBomVersion: String by settings
    val assertjVersion: String by settings


    versionCatalogs {
        create("libs") {
            library("org-junit", "org.junit", "junit-bom")
                .version(junitBomVersion)
            library("org-assertj", "org.assertj", "assertj-core")
                .version(assertjVersion)
        }
    }
}

rootProject.name = "yandex-practicum-algorithms"
include("chapter3")
include("chapter4")
include("chapter5")