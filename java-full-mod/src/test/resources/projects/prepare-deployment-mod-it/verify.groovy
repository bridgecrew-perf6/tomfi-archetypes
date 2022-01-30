import static java.nio.file.Files.isReadable

import java.util.Properties

def basePath = basedir.toPath()
def propsPath = basePath.resolve "archetype.properties"

def archetypeProps = new Properties()
propsPath.withInputStream {
    archetypeProps.load(it)
}

def targetArtifactId = archetypeProps.get "artifactId"
def targetVersion = archetypeProps.get "version"

def targetPath = basePath.resolve "project/$targetArtifactId/target"

def targetPitReport = targetPath.resolve "pit-reports/index.html"
def targetJacocoReport = targetPath.resolve "site/jacoco/index.html"
def targetJar = targetPath.resolve("$targetArtifactId-${targetVersion}.jar")
def targetJavadocJar = targetPath.resolve("$targetArtifactId-$targetVersion-javadoc.jar")
def targetSourcesJar = targetPath.resolve("$targetArtifactId-$targetVersion-sources.jar")

isReadable(targetPitReport) &&
    isReadable(targetJacocoReport) &&
    isReadable(targetJar) &&
    isReadable(targetJavadocJar) &&
    isReadable(targetSourcesJar)