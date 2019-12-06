enablePlugins(OpenAPIGeneratorPlugin)

version := "0.1"

scalaVersion := "2.12.10"

openapiInputSpec := uri("https://raw.githubusercontent.com/ory/hydra/master/docs/api.swagger.json")
openapiOutputDir := file("src_managed")
openapiGeneratorName := "java"
openapiLibrary := "native".some