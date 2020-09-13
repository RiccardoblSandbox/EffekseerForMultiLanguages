#!/bin/bash
set -e
if [ "$BUILD_DIR" = "" ];
then
    export BUILD_DIR="../build"
fi

if [ "$VERSION" = "" ];
then
    export VERSION="1.0"
fi


mkdir -p BUILD_DIR
bash ./generate_swig_wrapper.sh


javaClassesPath="$BUILD_DIR/java-classes"
javaSourcesPath="$BUILD_DIR/java-sources"
mavenPath="$BUILD_DIR/maven"
nativesPath="$BUILD_DIR/java-natives"

rm -R "$javaClassesPath" || true
rm -R "$javaSourcesPath" || true
rm -R "$mavenPath"|| true

mkdir -p "$javaClassesPath"
mkdir -p "$javaSourcesPath"
mkdir -p "$mavenPath"
mkdir -p "$nativesPath"

mkdir -p "$javaSourcesPath/Effekseer"
cp -Rf java/swig "$javaSourcesPath/Effekseer/swig"
javac $javaSourcesPath/Effekseer/swig/* -d "$javaClassesPath"

echo "
<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<project
  xmlns=\"http://maven.apache.org/POM/4.0.0\"
  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"
  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">
  <modelVersion>4.0.0</modelVersion>
  <groupId>effekseer</groupId>
 <artifactId>effekseer-native</artifactId>
 <version>$VERSION</version>
  <name>effekseer-native</name>
  <description></description>
  <url></url>
</project> 
" > "$mavenPath/pom.xml"

cp "$mavenPath/pom.xml" "$mavenPath/effekseer-native-$VERSION.pom"

cp -Rf "$nativesPath" "$javaClassesPath/native"

jar cf "$mavenPath/effekseer-native-$VERSION.jar"  -C $javaClassesPath .
jar cf "$mavenPath/eeffekseer-native-$VERSION-sources.jar"  -C $javaSourcesPath .