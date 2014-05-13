import sbt._

object NanorevolutionBuild extends Build {

  lazy val root = Project(id = "Parent",
    base = file(".")) aggregate(macroProject, mainProject)

  lazy val macroProject = Project(id = "MacroProject",
    base = file("macro"))

  lazy val mainProject = Project(id = "MainProject",
    base = file("main")
  ) dependsOn macroProject

}
