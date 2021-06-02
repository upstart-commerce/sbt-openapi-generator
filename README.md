[![Build Status](https://travis-ci.org/upstart-commerce/sbt-openapi-generator.svg?branch=master)](https://travis-ci.org/upstart-commerce/sbt-openapi-generator)
 [ ![Download](https://api.bintray.com/packages/upstartcommerce/generic/sbt-openapi-generator/images/download.svg) ](https://bintray.com/upstartcommerce/generic/sbt-openapi-generator/_latestVersion)

# sbt-openapi-generator
SBT plugin for openapi-generator

# Usage
Add the following to your `project/plugins.sbt`:
```
resolvers in Global += Resolver.url(
  "upstartcommerce-public",
  url("https://upstartcommerce.jfrog.io/artifactory/generic")
)(Resolver.ivyStylePatterns)

addSbtPlugin("org.upstartcommerce" % "sbt-openapi-generator" % "0.1.2") // Use the latest version from the badge above
```
and `build.sbt`:
```
enablePlugins(OpenAPIGeneratorPlugin)
```

Set `openapiInputSpec` setting to point to your OpenAPI specification file and `openapiGeneratorName` for a desired generator (list of supported generators is available [here](https://openapi-generator.tech/docs/generators)). Sources can then be generated using `openapiGenerate` task.

# Available settings
The two mandatory settings are `openapiInputSpec` and `openapiGeneratorName`, SBT will complain if you don't provide those. All the other setting keys are optional or have defaults.

| Setting | Type | Description |
|:-------:|:----:|:-----------:|
| openapiAdditionalProperties | Map[String, AnyRef] | Sets additional properties that can be referenced by the mustache templates in the format of name=value,name=value |
| openapiApiNameSuffix | Option[String] | Suffix for the generated API files |
| openapiApiPackage | Option[String] | Package for generated API classes |
| openapiArtifactId | Option[String] | ArtifactId in generated code. This also becomes part of the generated library's filename |
| openapiArtifactVersion | Option[String] | Artifact version in generated code. This also becomes part of the generated library's filename |
| openapiAuth | Option[String] | Adds authorization headers when fetching the OpenAPI definitions remotely. Pass in a URL-encoded string of name:header with a comma separating multiple values |
| openapiConfigFile | Option[File] | Path to configuration file configuration file. It can be JSON or YAML |
| openapiEnableMinimalUpdate | Boolean | Only write output files that have changed |
| openapiEnablePostProcessFile | Boolean | Enable post-processing file using environment variables |
| openapiGenerateAliasAsModel | Boolean | Generate alias to map, array as models |
| openapiGeneratorName | String | Generator to use |
| openapiGitRepoId | Option[String] | Git repo ID, e.g. openapi-generator |
| openapiGitUserId | Option[String] | Git user ID, e.g. openapitools |
| openapiGroupId | Option[String] | GroupId in generated code |
| openapiHttpUserAgent | Option[String] | HTTP user agent, e.g. codegen_csharp_api_client, default to 'OpenAPI-Generator/{packageVersion}}/{language}' |
| openapiIgnoreFileOverride | Option[String] | Specifies an override location for the .openapi-generator-ignore file. Most useful on initial generation |
| openapiImportMappings | Map[String, String] | Specifies mappings between a given class and the import that should be used for that class in the format of type=import,type=import |
| openapiInputSpec | URI | Location of the OpenAPI spec, as URL or file (required) |
| openapiInstantiationTypes | Map[String, String] | Sets instantiation type mappings in the format of type=instantiatedType,type=instantiatedType. For example (in Java): array=ArrayList,map=HashMap. In other words array types will get instantiated as ArrayList in generated code |
| openapiInvokerPackage | Option[String] | Root package for generated code |
| openapiLanguageSpecificPrimitives | Set[String] | Specifies additional language specific primitive types in the format of type1,type2,type3,type3. For example: String,boolean,Boolean,Double |
| openapiLibrary | Option[String] | Library template (sub-template) |
| openapiLogToStderr | Boolean | write all log messages (not just errors) to STDERR. Useful for piping the JSON output of debug options (e.g. `-DdebugOperations`) to an external parser directly while testing a generator |
| openapiModelNamePrefix | Option[String] | Prefix that will be prepended to all model names |
| openapiModelNameSuffix | Option[String] | Suffix that will be appended to all model names |
| openapiModelPackage | Option[String] | Package for generated models |
| openapiOutputDir | File | Where to write the generated files (current dir by default) |
| openapiPackageName | Option[String] | Package for generated classes (where supported) |
| openapiReleaseNote | Option[String] | Release note, default to 'Minor update' |
| openapiRemoveOperationIdPrefix | Boolean | Remove prefix of operationId, e.g. config_getId => getId |
| openapiReservedWordsMappings | Map[String, String] | Specifies how a reserved name should be escaped to. Otherwise, the default _<name> is used. For example id=identifier |
| openapiSkipOverwrite | Boolean | Specifies if the existing files should be overwritten during the generation |
| openapiStrictSpecBehavior | Boolean | 'MUST' and 'SHALL' wording in OpenAPI spec is strictly adhered to. e.g. when false, no fixes will be applied to documents which pass validation but don't follow the spec |
| openapiSystemProperties | Map[String, String] | Sets specified system properties in the format of name=value,name=value (or multiple options, each with name=value) |
| openapiTemplateDir | Option[File] | Folder containing the template files |
| openapiTemplatingEngineName | Option[String] | Templating engine: \"mustache\" (default) or \"handlebars\" (beta) |
| openapiTypeMappings | Map[String, String] | Sets mappings between OpenAPI spec types and generated code types in the format of OpenAPIType=generatedType,OpenAPIType=generatedType. For example: array=List,map=Map,string=String |
| openapiValidateSpec | Boolean | Validate spec before code generation |
| openapiVerbose | Boolean | Verbose mode |

