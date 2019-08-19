package org.upstartcommerce.openapi

import sbt._
import sbt.io.syntax.File

trait OpenAPIGeneratorKeys {
  lazy val openapiAdditionalProperties = settingKey[Map[String, AnyRef]](
    "Sets additional properties that can be referenced by the mustache templates in the format of name=value,name=value"
  )
  lazy val openapiApiPackage = settingKey[Option[String]]("Package for generated API classes")
  lazy val openapiArtifactId = settingKey[Option[String]](
    "ArtifactId in generated code. This also becomes part of the generated library's filename"
  )
  lazy val openapiArtifactVersion = settingKey[Option[String]](
    "Artifact version in generated code. This also becomes part of the generated library's filename"
  )
  lazy val openapiAuth = settingKey[Option[String]](
    "Adds authorization headers when fetching the OpenAPI definitions remotely. Pass in a URL-encoded string of name:header with a comma separating multiple values"
  )
  lazy val openapiConfigFile = settingKey[Option[File]](
    "Path to configuration file configuration file. It can be JSON or YAML"
  )
  lazy val openapiEnableMinimalUpdate = settingKey[Boolean]("Only write output files that have changed")
  lazy val openapiEnablePostProcessFile =
    settingKey[Boolean]("Enable post-processing file using environment variables")
  lazy val openapiGenerateAliasAsModel = settingKey[Boolean]("Generate alias to map, array as models")
  lazy val openapiGeneratorName = settingKey[String]("Generator to use")
  lazy val openapiGitRepoId = settingKey[Option[String]]("Git repo ID, e.g. openapi-generator")
  lazy val openapiGitUserId = settingKey[Option[String]]("Git user ID, e.g. openapitools")
  lazy val openapiGroupId = settingKey[Option[String]]("GroupId in generated code")
  lazy val openapiHttpUserAgent = settingKey[Option[String]](
    "HTTP user agent, e.g. codegen_csharp_api_client, default to 'OpenAPI-Generator/{packageVersion}}/{language}'"
  )
  lazy val openapiIgnoreFileOverride = settingKey[Option[String]](
    "Specifies an override location for the .openapi-generator-ignore file. Most useful on initial generation"
  )
  lazy val openapiImportMappings = settingKey[Map[String, String]](
    "Specifies mappings between a given class and the import that should be used for that class in the format of type=import,type=import"
  )
  lazy val openapiInputSpec = settingKey[File]("Location of the OpenAPI spec, as URL or file (required)")
  lazy val openapiInstantiationTypes = settingKey[Map[String, String]](
    "Sets instantiation type mappings in the format of type=instantiatedType,type=instantiatedType. For example (in Java): array=ArrayList,map=HashMap. In other words array types will get instantiated as ArrayList in generated code"
  )
  lazy val openapiInvokerPackage = settingKey[Option[String]]("Root package for generated code")
  lazy val openapiLanguageSpecificPrimitives = settingKey[Set[String]](
    "Specifies additional language specific primitive types in the format of type1,type2,type3,type3. For example: String,boolean,Boolean,Double"
  )
  lazy val openapiLibrary = settingKey[Option[String]]("Library template (sub-template)")
  lazy val openapiLogToStderr = settingKey[Boolean](
    "write all log messages (not just errors) to STDERR. Useful for piping the JSON output of debug options (e.g. `-DdebugOperations`) to an external parser directly while testing a generator"
  )
  lazy val openapiModelNamePrefix =
    settingKey[Option[String]]("Prefix that will be prepended to all model names")
  lazy val openapiModelNameSuffix =
    settingKey[Option[String]]("Suffix that will be appended to all model names")
  lazy val openapiModelPackage = settingKey[Option[String]]("Package for generated models")
  lazy val openapiOutputDir =
    settingKey[File]("Where to write the generated files (current dir by default)")
  lazy val openapiPackageName =
    settingKey[Option[String]]("Package for generated classes (where supported)")
  lazy val openapiReleaseNote = settingKey[Option[String]]("Release note, default to 'Minor update'")
  lazy val openapiRemoveOperationIdPrefix =
    settingKey[Boolean]("Remove prefix of operationId, e.g. config_getId => getId")
  lazy val openapiReservedWordsMappings = settingKey[Map[String, String]](
    "Specifies how a reserved name should be escaped to. Otherwise, the default _<name> is used. For example id=identifier"
  )
  lazy val openapiSkipOverwrite = settingKey[Boolean](
    "Specifies if the existing files should be overwritten during the generation"
  )
  lazy val openapiStrictSpecBehavior = settingKey[Boolean](
    "'MUST' and 'SHALL' wording in OpenAPI spec is strictly adhered to. e.g. when false, no fixes will be applied to documents which pass validation but don't follow the spec"
  )
  lazy val openapiSystemProperties = settingKey[Map[String, String]](
    "Sets specified system properties in the format of name=value,name=value (or multiple options, each with name=value)"
  )
  lazy val openapiTemplateDir = settingKey[Option[File]]("Folder containing the template files")
  lazy val openapiTemplatingEngineName =
    settingKey[Option[String]]("Templating engine: \"mustache\" (default) or \"handlebars\" (beta)")
  lazy val openapiTypeMappings = settingKey[Map[String, String]](
    "Sets mappings between OpenAPI spec types and generated code types in the format of OpenAPIType=generatedType,OpenAPIType=generatedType. For example: array=List,map=Map,string=String"
  )
  lazy val openapiValidateSpec = settingKey[Boolean]("Validate spec before code generation")
  lazy val openapiVerbose = settingKey[Boolean]("Verbose mode")

  lazy val openapiGenerate = taskKey[Unit]("Generates code from OpenAPI specification")
}
