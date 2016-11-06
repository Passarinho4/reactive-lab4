
name := """reactive-lab4"""

version := "1.1"

scalaVersion := "2.11.8"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.11",
  "com.typesafe.akka" %% "akka-persistence" % "2.4.11",
  "org.iq80.leveldb"            % "leveldb"          % "0.7",
  "org.fusesource.leveldbjni"   % "leveldbjni-all"   % "1.8",
  "com.github.ironfish" %% "akka-persistence-mongo-casbah"  % "0.7.6" % "compile"
)
  

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

