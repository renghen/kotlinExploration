import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.mcb"
version = "1.0-SNAPSHOT"
val arrowVersion = "0.9.0"
val kotlinCoroutineVersion = "1.2.1"
val kittinFuel = "2.0.1"

repositories {
    jcenter()
    mavenCentral()
}

plugins {
    val kotlinVersion = "1.3.31"
    idea
    kotlin("jvm") version kotlinVersion
    `java-library`
    kotlin("kapt") version  kotlinVersion
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")

    //slf4j and logback
    implementation("org.slf4j:slf4j-api:1.7.26")
//    implementation("org.slf4j:jcl-over-slf4j")

    //fuel
    implementation("com.github.kittinunf.fuel:fuel:$kittinFuel")
    implementation("com.github.kittinunf.fuel:fuel-coroutines:$kittinFuel")

    //arrow libs
    implementation("io.arrow-kt:arrow-core-data:$arrowVersion")
    implementation("io.arrow-kt:arrow-core-extensions:$arrowVersion")
    implementation("io.arrow-kt:arrow-syntax:$arrowVersion")
    implementation("io.arrow-kt:arrow-typeclasses:$arrowVersion")
    implementation("io.arrow-kt:arrow-extras-data:$arrowVersion")
    implementation("io.arrow-kt:arrow-extras-extensions:$arrowVersion")
    kapt("io.arrow-kt:arrow-meta:$arrowVersion")

    implementation( "io.arrow-kt:arrow-query-language:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-free-data:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-free-extensions:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-mtl:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-effects-data:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-effects-extensions:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-effects-io-extensions:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-effects-rx2-data:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-effects-rx2-extensions:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-effects-reactor-data:$arrowVersion") //optional
    implementation( "io.arrow-kt:arrow-effects-reactor-extensions:$arrowVersion") //optional
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}