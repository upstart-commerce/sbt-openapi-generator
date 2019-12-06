package org.upstartcommerce.openapi

import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.config.CodegenConfigurator
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin

import scala.collection.JavaConverters._
import scala.language.implicitConversions
import scala.util.{Failure, Success, Try}

object OpenAPIGeneratorPlugin extends AutoPlugin {
  override def trigger = noTrigger

  override def requires = JvmPlugin

  object autoImport extends OpenAPIGeneratorKeys

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] =
    Seq(
      openapiAdditionalProperties := Map.empty,
      openapiApiPackage := None,
      openapiArtifactId := None,
      openapiArtifactVersion := None,
      openapiAuth := None,
      openapiConfigFile := None,
      openapiEnableMinimalUpdate := false,
      openapiEnablePostProcessFile := false,
      openapiGenerateAliasAsModel := false,
      openapiGitRepoId := None,
      openapiGitUserId := None,
      openapiGroupId := None,
      openapiHttpUserAgent := None,
      openapiIgnoreFileOverride := None,
      openapiImportMappings := Map.empty,
      openapiInstantiationTypes := Map.empty,
      openapiInvokerPackage := None,
      openapiLanguageSpecificPrimitives := Set.empty,
      openapiLibrary := None,
      openapiLogToStderr := false,
      openapiModelNamePrefix := None,
      openapiModelNameSuffix := None,
      openapiModelPackage := None,
      openapiOutputDir := baseDirectory.value / "generated",
      openapiPackageName := None,
      openapiReleaseNote := None,
      openapiRemoveOperationIdPrefix := false,
      openapiReservedWordsMappings := Map.empty,
      openapiSkipOverwrite := false,
      openapiStrictSpecBehavior := false,
      openapiSystemProperties := Map.empty,
      openapiTemplateDir := None,
      openapiTemplatingEngineName := None,
      openapiTypeMappings := Map.empty,
      openapiValidateSpec := false,
      openapiVerbose := false,
      openapiGenerate := generateTask.value
    )

  private def generateTask = Def.task {
    val configurator = openapiConfigFile.value
      .map(
        v =>
          Try(CodegenConfigurator.fromFile(v.getAbsolutePath)) match {
            case Success(v) => v
            case Failure(e) =>
              sLog.value.error(s"Failed to read configuration file : ${e.getLocalizedMessage}")
              new CodegenConfigurator()
          }
      )
      .getOrElse(new CodegenConfigurator())
    configurator.setAdditionalProperties(openapiAdditionalProperties.value.asJava)
    openapiApiPackage.value.foreach(v => configurator.setApiPackage(v))
    openapiArtifactId.value.foreach(v => configurator.setArtifactId(v))
    openapiArtifactVersion.value.foreach(v => configurator.setArtifactVersion(v))
    openapiAuth.value.foreach(v => configurator.setAuth(v))
    configurator.setEnableMinimalUpdate(openapiEnableMinimalUpdate.value)
    configurator.setEnablePostProcessFile(openapiEnablePostProcessFile.value)
    configurator.setGenerateAliasAsModel(openapiGenerateAliasAsModel.value)
    configurator.setGeneratorName(openapiGeneratorName.value)
    openapiGitRepoId.value.foreach(v => configurator.setGitRepoId(v))
    openapiGitUserId.value.foreach(v => configurator.setGitUserId(v))
    openapiGroupId.value.foreach(v => configurator.setGroupId(v))
    openapiHttpUserAgent.value.foreach(v => configurator.setHttpUserAgent(v))
    openapiIgnoreFileOverride.value.foreach(v => configurator.setIgnoreFileOverride(v))
    configurator.setImportMappings(openapiImportMappings.value.asJava)
    configurator.setInputSpec(openapiInputSpec.value.toString)
    configurator.setInstantiationTypes(openapiInstantiationTypes.value.asJava)
    openapiInvokerPackage.value.foreach(v => configurator.setInvokerPackage(v))
    configurator.setLanguageSpecificPrimitives(openapiLanguageSpecificPrimitives.value.asJava)
    openapiLibrary.value.foreach(v => configurator.setLibrary(v))
    configurator.setLogToStderr(openapiLogToStderr.value)
    openapiModelNamePrefix.value.foreach(v => configurator.setModelNamePrefix(v))
    openapiModelNameSuffix.value.foreach(v => configurator.setModelNameSuffix(v))
    openapiModelPackage.value.foreach(v => configurator.setModelPackage(v))
    configurator.setOutputDir(openapiOutputDir.value.getAbsolutePath)
    openapiPackageName.value.foreach(v => configurator.setPackageName(v))
    openapiReleaseNote.value.foreach(v => configurator.setReleaseNote(v))
    configurator.setRemoveOperationIdPrefix(openapiRemoveOperationIdPrefix.value)
    configurator.setReservedWordsMappings(openapiReservedWordsMappings.value.asJava)
    configurator.setSkipOverwrite(openapiSkipOverwrite.value)
    configurator.setStrictSpecBehavior(openapiStrictSpecBehavior.value)
    configurator.setSystemProperties(openapiSystemProperties.value.asJava)
    openapiTemplateDir.value.foreach(v => configurator.setTemplateDir(v.getAbsolutePath))
    openapiTemplatingEngineName.value.foreach(v => configurator.setTemplatingEngineName(v))
    configurator.setTypeMappings(openapiTypeMappings.value.asJava)
    configurator.setValidateSpec(openapiValidateSpec.value)
    configurator.setVerbose(openapiVerbose.value)

    new DefaultGenerator().opts(configurator.toClientOptInput).generate()
  }

  implicit def f[T](t: T): Option[T] = Option(t)
}
