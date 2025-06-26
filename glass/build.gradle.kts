plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
    signing
}

android {
    namespace = "com.mrtdk.glass"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
    
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.material3)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
}

// Maven Publishing Configuration
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.mrtdk"
            artifactId = "glass"
            version = "0.1.0"
            
            afterEvaluate {
                from(components["release"])
            }
            
            pom {
                name.set("Glass")
                description.set("A library for creating glass morphism effects in Jetpack Compose with support for Android API 24+")
                url.set("https://github.com/Mortd3kay/liquid-glass-compose")
                
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }
                
                developers {
                    developer {
                        id.set("mrtdk")
                        name.set("MRTDK")
                        email.set("undergroundcome@gmail.com")
                    }
                }
                
                scm {
                    connection.set("scm:git:git://github.com/Mortd3kay/liquid-glass-compose.git")
                    developerConnection.set("scm:git:ssh://github.com/Mortd3kay/liquid-glass-compose.git")
                    url.set("https://github.com/Mortd3kay/liquid-glass-compose")
                }
            }
        }
    }
    
    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = project.findProperty("ossrhUsername") as String?
                password = project.findProperty("ossrhPassword") as String?
            }
        }
    }
}

// Signing Configuration
signing {
    val signingKeyId = project.findProperty("signing.keyId") as String?
    val signingPassword = project.findProperty("signing.password") as String?
    val signingSecretKeyRingFile = project.findProperty("signing.secretKeyRingFile") as String?
    
    if (signingKeyId != null) {
        useInMemoryPgpKeys(signingKeyId, signingSecretKeyRingFile, signingPassword)
        sign(publishing.publications)
    }
}