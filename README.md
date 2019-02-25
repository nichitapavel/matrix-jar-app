# Matrix operations library made in Java

## Requirements
- [gradle 5.1](https://gradle.org/releases/)
- [oracle/open jdk => v1.8_u191](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
(Works with v1.6 too)

## Instructions
After cloning use these commands to compile
- `./gradlew build`


Make use of the compiled app:
- go to *build/distributions/*
- extract either **.zip** or **.tar** archive
- go to *matrix-jar-app-<version>/bin/*, here are the executables **matrix-jar-app**/**matrix-jar-app.bat**
- execute by typing `./matrix-jar-app 10 10 true` or `matrix-jar-app.bat 10 10 true` 


## Arguments
The app has 3 arguments, all are required
- **String** type **Integer** tells the size of the matrixes (only square matrixes are possible)
- **String** type **Integer** tells the maximum value of a coordinate, i.e.: if this value is 40 you will never have in the 
matrix a number equal or higher to 40
- **String** type **boolean** `false` or `true` tells if you want the matrixes to be printed


## Oracle vs Open JRE
By default the generated binary uses java runtime returned from `which java`, usually this is **Open JRE**. If you want
to use Oracle JRE you must specify JAVA_HOME to that runtime, i.e.: `JAVA_HOME=/opt/jre1.8.0_202 ./matrix-jar-app 10 10
 true`

## Current version: 0.2.1
