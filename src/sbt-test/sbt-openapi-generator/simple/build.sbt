enablePlugins(OpenAPIGeneratorPlugin)

version := "0.1"

scalaVersion := "2.12.8"

openapiInputSpec := file("petstore.yaml")
openapiOutputDir := file("generated")
openapiGeneratorName := "scala-lagom-server"