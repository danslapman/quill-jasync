val versions = Map(
  "quill" -> "3.5.0",
  "jasync" -> "1.0.14"
)

val `quill-jasync` = (project in file("quill-jasync"))
  .settings(Settings.common)
  .settings(
    name := "quill-jasync",
    libraryDependencies ++= Seq(
      "io.getquill" %% "quill-sql" % versions("quill"),
      "com.github.jasync-sql" % "jasync-common" % versions("jasync"),
      "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.1"
    )
  )

val `quill-jasync-postgres` = (project in file("quill-jasync-postgres"))
  .settings(Settings.common)
  .settings(
    name := "quill-jasync-postgres",
    libraryDependencies ++= Seq(
      "com.github.jasync-sql" % "jasync-postgresql" % versions("jasync")
    )
  )
  .dependsOn(`quill-jasync` % "compile->compile;test->test")

val root = (project in file("."))
  .dependsOn(`quill-jasync`, `quill-jasync-postgres`)
  .aggregate(`quill-jasync`, `quill-jasync-postgres`)
  .settings(Settings.common)
  .settings(
    publish := {},
    bintrayRelease := {},
    bintrayUnpublish := {}
  )
