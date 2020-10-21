plugins {
    java
    kotlin("jvm") version "1.3.72"
    jacoco
    id ("org.flywaydb.flyway") version "6.1.0"
}

group = "org.backendlabs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

flyway {
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "123456"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.javalin:javalin:3.9.1")
    implementation("org.slf4j:slf4j-simple:1.8.0-beta4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.3")
    implementation("com.github.kittinunf.fuel:fuel:2.2.3")
    implementation("com.github.kittinunf.result:result:3.1.0")
    implementation("com.zaxxer:HikariCP:3.4.5")
    implementation("org.jetbrains.exposed:exposed-core:0.27.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.27.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.27.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.27.1")
    implementation("org.postgresql:postgresql:42.2.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testImplementation("io.mockk:mockk:1.10.0")
    testImplementation("org.jacoco:org.jacoco.agent:0.8.5")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.destination = file("${buildDir}/jacocoHtml")
    }
}

jacoco {
    toolVersion = "0.8.5"
    reportsDir = file("$buildDir/customJacocoReportDir")
}