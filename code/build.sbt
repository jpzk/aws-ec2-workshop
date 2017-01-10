cancelable in Global := true

lazy val commonSettings = Seq(
  organization := "mwt.ec2app",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.11.8",
  description := "ec2app",
  parallelExecution in Test := false,

  resolvers += Resolver.sonatypeRepo("snapshots"),
  resolvers += Resolver.sonatypeRepo("releases"),
  resolvers ++= Seq(
    "twttr" at "http://maven.twttr.com/",
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
  ))

lazy val ec2app = (project in file("ec2app")).
  settings(commonSettings: _*).
  settings(assemblyMergeStrategy in assembly := {
    case PathList("org", "slf4j", "impl", xs@_*) => MergeStrategy.first
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  }).
  settings(
    assemblyJarName in assembly := "ec2app.jar"
  ).
  settings(
    libraryDependencies ++= Seq(
      awscala
    ) ++ logging
  )

val scalaLoggingVersion = "3.4.0"
val log4jVersion = "1.2.17"
val slf4jVersion = "1.7.21"

// Amazon AWS
lazy val awscala = "com.github.seratch" %% "awscala" % "0.5.+"

// Common

// Bridge
lazy val typesafeLogging = "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion
lazy val twitter4j = "org.twitter4j" % "twitter4j-core" % "4.0.4"

lazy val logging = Seq("ch.qos.logback" % "logback-classic" % "1.1.3",
  "org.logback-extensions" % "logback-ext-loggly" % "0.1.2",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0")

