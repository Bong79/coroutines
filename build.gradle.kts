////import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//
////plugins {
////    kotlin("jvm") version "1.4.21"
////}
////
////group = "com.raywenderlich"
////version ="1.0-SNAPSHOT"
////
////repositories{
////    mavenCentral()
////    jcenter()
////}
////
//////tasks.withType
//////<KotlinCompile>()
////compileKotlin {
////    kotlinOptions.jvmTarget = "1.8"
////}
////
////dependencies {
////    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core: 1.4.0"
////}
////
//
////import KotlinCompile
//
//
//plugins {
//    id ('java')
//    id ('org.jetbrains.kotlin.jvm') version '1.4.21'
//}
//
//group 'org.example'
//version '1.0-SNAPSHOT'
//
//repositories {
//    mavenCentral()
//    jcenter()
//}
//
//dependencies {
//    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core: 1.4.0"
//
//    testCompile group: 'junit', name: 'junit', version: '4.12'
//}
//
//compileKotlin {
//    kotlinOptions.jvmTarget = "1.8"
//}
//compileTestKotlin {
//    kotlinOptions.jvmTarget = "1.8"
//}
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "com.raywenderlich"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
//    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:jdk7")
//    implementation ("androidx.core:core-ktx:1.6.0")

//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7")
////    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
////    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-RC2'
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}