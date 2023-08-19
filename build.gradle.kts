

val  kotlin_version = "1.6.10"

plugins {
    java
    kotlin("jvm") version "1.6.10"

}



group = "org.example"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("io.reactivex.rxjava3:rxjava:3.0.12")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlin_version}")

    testCompile("junit", "junit", "4.12")

    implementation("org.bouncycastle:bcprov-jdk16:1.46")
    implementation("com.alibaba:fastjson:1.1.36")
    implementation("commons-codec:commons-codec:1.7")
}
