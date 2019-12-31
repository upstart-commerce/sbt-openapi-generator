enablePlugins(OpenAPIGeneratorPlugin)

version := "0.1"

scalaVersion := "2.12.10"

openapiApiNameSuffix := Some("ApiNameSuffix")
openapiInputSpec := uri("petstore.yaml")
openapiOutputDir := file("generated")
openapiGeneratorName := "scala-lagom-server"