import sbt._
import Keys._

object NanorevolutionBuild extends Build {

  lazy val macroSub = Project("macro", file("macro")) settings (
    scalaVersion := "2.11.0",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "io.spray" %% "spray-json" % "1.2.6"
    )
  )

  lazy val main = Project("main", file(".")) settings (
    name := "nanorevolution",
    version := "0.1-SNAPSHOT",
    mainClass in (Compile, run) := Some("me.fornever.nano.Application"),
    scalacOptions += "-Ymacro-debug-lite",
    scalaVersion := "2.11.0",
    resolvers += "spray" at "http://repo.spray.io/",
    libraryDependencies ++= Seq(
      "org.mashupbots.socko" %% "socko-webserver" % "0.4.2",
      "io.spray" %%  "spray-json" % "1.2.6",
      "org.scalatest" %% "scalatest" % "2.1.3" % "test",
      "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  ) dependsOn macroSub

}
