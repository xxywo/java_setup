plugins {
  java
  jacoco
  pmd
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.testng:testng:7.5")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
  testImplementation("org.junit.platform:junit-platform-console:1.8.2")
}

tasks {
  val flags = listOf("-Xlint:unchecked", "-Xlint:deprecation", "-Werror")

  getByName<JavaCompile>("compileJava") {
    options.compilerArgs = flags
  }

  getByName<JavaCompile>("compileTestJava") {
    options.compilerArgs = flags
  }
}

sourceSets {
  main {
    java.srcDirs("Sample/src")
  }
  test {
    java.srcDirs("Sample/test")
  }
}

val test by tasks.getting(Test::class) {
  useJUnitPlatform {}
}

pmd {
  ruleSets = listOf()
  ruleSetFiles = files("../conf/pmd/ruleset.xml")
  toolVersion = "6.37.0"
}

tasks.withType<JacocoReport> {
  afterEvaluate {
    classDirectories.setFrom(files(classDirectories.files.map {
      fileTree(it).apply {
        exclude("*/preview/*")
      }
    }))
  }
}

defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")