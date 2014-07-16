name := "json4s-spire"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1","2.10.4")

organization := "com.mdedetrich"

version := "1.0.0"

libraryDependencies ++= Seq(
  "org.spire-math" %% "spire" % "0.7.4",
  "org.json4s" %% "json4s-jackson" % "3.2.10",
  "org.scalatest" % "scalatest" % "2.2.0" % "test" cross CrossVersion.binary
)
