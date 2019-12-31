// Testing
libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

// Linter
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.3")

// Bintray repository
addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.4")