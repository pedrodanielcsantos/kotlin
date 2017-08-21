
import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply { plugin("kotlin") }

dependencies {
    val compile by configurations
    compile(project(":core:builtins"))
    compile(project("util.runtime"))
    compile(protobufLite())
    compile(commonDep("javax.inject"))
}

sourceSets {
    "main" {
        java.srcDirs("descriptor.loader.java/src",
                     "descriptors/src",
                     "descriptors.runtime/src",
                     "deserialization/src")
        resources.srcDirs("descriptor.loader.java/src", "deserialization/src").apply { include("META-INF/**") }
    }
    "test" {}
}

tasks.withType<JavaCompile> {
    dependsOn(protobufLiteTask)
}

tasks.withType<KotlinCompile> {
    dependsOn(protobufLiteTask)
}

