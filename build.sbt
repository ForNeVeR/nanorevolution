name := "nanorevolution"

version := "0.1-SNAPSHOT"

mainClass in (Compile, run) := Some("me.fornever.nano.Application")

scalaVersion := "2.10.4"

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++= Seq(
  "org.mashupbots.socko" %% "socko-webserver" % "0.4.1",
  "io.spray" %%  "spray-json" % "1.2.6",
  "org.scalatest" %% "scalatest" % "2.1.0" % "test"
)
