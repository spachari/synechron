name := "synechron"

version := "0.1"

scalaVersion := "2.11.11"
val scalaCheckVersion   = "1.13.4"
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "junit" % "junit" % "4.12",
  "org.scalacheck"    %% "scalacheck"      % scalaCheckVersion % "test",
  "org.mockito" % "mockito-core" % "1.8.5")
