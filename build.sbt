name := "json4s-spire"

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.11.7","2.10.5")

organization := "org.mdedetrich"

version := "1.1.0"

libraryDependencies ++= Seq(
  "org.spire-math" %% "spire" % "0.7.4",
  "org.json4s" %% "json4s-jackson" % "3.3.0",
  "org.scalatest" % "scalatest" % "2.2.0" % "test" cross CrossVersion.binary
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := <url>https://github.com/mdedetrich/json4s-spire</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:mdedetrich/soda-time.git</url>
    <connection>scm:git:git@github.com:mdedetrich/json4s-spire.git</connection>
  </scm>
  <developers>
    <developer>
      <id>mdedetrich</id>
      <name>Matthew de Detrich</name>
      <email>mdedetrich@gmail.com</email>
    </developer>
  </developers>