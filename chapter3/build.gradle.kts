java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    testImplementation(platform(libs.org.junit))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(libs.org.assertj)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}