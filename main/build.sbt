name := "nanorevolution"

version := "0.1-SNAPSHOT"

mainClass in (Compile, run) := Some("me.fornever.nano.Application")

scalacOptions += "-Ymacro-debug-lite"

scalaVersion := "2.11.0"

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++= Seq(
  "org.mashupbots.socko" %% "socko-webserver" % "0.4.2",
  "io.spray" %%  "spray-json" % "1.2.6",
  "org.scalatest" %% "scalatest" % "2.1.3" % "test",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)