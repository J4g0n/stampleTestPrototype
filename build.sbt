name := """stamplePrototype"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
// libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"


libraryDependencies ++= Seq(
  "org.scalatest"						%		"scalatest_2.11" 	%	"2.2.4",
  "com.codeborne"						%		"phantomjsdriver" 	%	"1.2.1",
  // "com.github.detro"						%		"phantomjsdriver" 	%	"1.2.0",
  // "org.specs2" 							%%	"specs2" 					%	"2.1.1"			%	"test",
  "org.seleniumhq.selenium"	%		"selenium-java" 	%	"2.48.2",
  "org.typelevel" %% "cats" % "0.4.1"
  // "org.jenkins-ci.plugins" % "sbt" % "1.5"
)

testOptions in Test += Tests.Argument("-oD")

parallelExecution in Test := false
concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)
//parallelExecution in ScctPlugin.ScctTest := false

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

