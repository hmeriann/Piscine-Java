# Delete target directory
rm -rf target
#rm -rf lib

# Make target directory
mkdir target
#mkdir lib

#touch lib/jcommander-1.78.jar
#curl -o lib/jcommander-1.78.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.78/jcommander-1.78.jar
#touch lib/JCDP-2.0.3.1.jar
#curl -o lib/JCDP-2.0.3.1.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/2.0.3.1/JCDP-2.0.3.1.jar

# Set the destination directory for class files
javac -cp ".:./lib/JCDP-2.0.3.1.jar:./lib/jcommander-1.78.jar" -d ./target/ src/java/edu/school21/printer/*/*.java

# Copy resources
cp -R src/resources target/.

# Create JAR file in the target directory
cd target ; jar xf ../lib/JCDP-2.0.3.1.jar com ; jar xf ../lib/jcommander-1.78.jar com ; cd ..
rm -f ./target/images-to-chars-printer.jar
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .


chmod u+x target/images-to-chars-printer.jar

# Specify how to execute unpacked file
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN