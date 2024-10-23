import java.io.FileInputStream
import java.util.Properties

plugins {
         alias(libs.plugins.android.library)
         alias(libs.plugins.jetbrains.kotlin.android)
         id("maven-publish")
}

android {
         namespace = "com.lakshya.zoomlayout"
         compileSdk = 34

         defaultConfig {
                  minSdk = 24

                  testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                  consumerProguardFiles("consumer-rules.pro")
         }

         buildTypes {
                  release {
                           isMinifyEnabled = false
                           proguardFiles(
                                    getDefaultProguardFile("proguard-android-optimize.txt"),
                                    "proguard-rules.pro"
                           )
                  }
         }
         compileOptions {
                  sourceCompatibility = JavaVersion.VERSION_1_8
                  targetCompatibility = JavaVersion.VERSION_1_8
         }
         kotlinOptions {
                  jvmTarget = "1.8"
         }
}


publishing {
         publications {
                  register<MavenPublication>("release") {
                           groupId = "com.github.Lakshya-2001"
                           artifactId = "zoomlayoutpro"
                           version = "1.0.1"

                           afterEvaluate {
                                    from(components["release"])
                           }
                  }
         }
         repositories {
                  maven {
                           name = "zoomlayoutpro"
                           url = uri("https://maven.pkg.github.com/Lakshya-2001/zoomlayoutpro")

                           }
                  }
         }
}
dependencies {
         implementation(libs.egloo)
         implementation(libs.androidx.core.ktx)
         implementation(libs.androidx.appcompat)
         implementation(libs.material)

         testImplementation(libs.junit)
         androidTestImplementation(libs.androidx.junit)
         androidTestImplementation(libs.androidx.espresso.core)
}