val commonSettings = Seq(
     scalaVersion := "3.6.3",
     libraryDependencies ++= Seq(
          "org.typelevel" %% "cats-effect" % "3.2.9",
          "org.typelevel" %% "munit-cats-effect-3" % "1.0.5"
          // "org.typelevel" %% "cats-mtl" % "1.2.1"
     )
)

val shared = project.settings(commonSettings)
val server = project.settings(commonSettings).dependsOn(shared)

val client = project.settings(commonSettings).dependsOn(shared)

val root = project
    .in(file("."))
    .settings()
    .aggregate(server, client, shared)