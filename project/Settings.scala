import bintray.BintrayKeys._
import sbt._
import sbt.Keys._

object Settings {
  val common = Seq(
    organization := "io.getquill",
    version := "3.5.0",
    scalaVersion := "2.13.1",
    crossScalaVersions := Seq("2.12.10", "2.13.1"),
    scalacOptions ++= Seq(
      "-language:higherKinds,implicitConversions",
      "-encoding", "UTF-8"
    ),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    bintrayOrganization := Some("danslapman"),
    bintrayReleaseOnPublish in ThisBuild := false
  )
}