plugins {
    id("com.vanniktech.maven.publish")
    id("java-platform")
}

dependencies {
    constraints {
        api(projects.openaiCore)
        api(projects.openaiClient)
        api(libs.ktor.client.apache)
        api(libs.ktor.client.cio)
        api(libs.ktor.client.java)
        api(libs.ktor.client.jetty)
        api(libs.ktor.client.okhttp)
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
                artifactId = "openai-client-bom"
                version = "3.3.3"
            }
        }
    }
}
