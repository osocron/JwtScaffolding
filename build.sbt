name := "JwtScaffolding"
 
version := "1.0" 
      
lazy val `jwtscaffolding` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(jdbc, ehcache, ws, specs2 % Test, guice)

val jwtCoreVersion = "2.1.0"
libraryDependencies ++= Seq(
  "com.pauldijou" %% "jwt-core",
  "com.pauldijou" %% "jwt-play-json",
  "com.pauldijou" %% "jwt-circe"
).map(_ % jwtCoreVersion)

val circeVersion = "0.10.0"
libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies ++= Seq("com.auth0" % "jwks-rsa" % "0.8.0")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      