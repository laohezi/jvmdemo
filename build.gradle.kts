

val  kotlin_version = "2.0.21"

plugins {
    java
    kotlin("jvm") version "2.0.21"

}



group = "org.example"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlin_version}")

    testImplementation("junit:junit:4.13.2")

    implementation("commons-codec:commons-codec:1.16.0")
    
    // FastJSON for JSON processing
    implementation("com.alibaba:fastjson:2.0.43")
    
    // BouncyCastle for cryptography
    implementation("org.bouncycastle:bcprov-jdk18on:1.76")
}
