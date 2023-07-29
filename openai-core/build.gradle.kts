plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.vanniktech.maven.publish")
    id("binary-compatibility-validator")
    id("com.diffplug.spotless")
    id("org.jetbrains.dokka")
    id("build-support")
}

kotlin {
    explicitApi()
    jvm()
    jsNode()
    native()

    sourceSets {
        all {
            languageSettings.apply{
                optIn("kotlinx.serialization.ExperimentalSerializationApi")
            }
        }
        val commonMain by getting {
            dependencies {
                api(libs.okio)
                api(libs.serialization.json)
                implementation(libs.serialization.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            register("release", MavenPublication::class) {
                // Applies the component for the release build variant.
                from(components.getByName("release"))
                // You can then customize attributes of the publication as shown below.
                groupId = "com.github.wilinz"
                artifactId = "openai-core"
                version = "3.3.3"
            }
        }
    }
}