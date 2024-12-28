plugins {
    id("java")
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "inc.PrettyHateMachin.e"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}




tasks.test {
    useJUnitPlatform()
}