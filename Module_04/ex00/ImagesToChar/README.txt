# Delete target directory
rm -rf target

# Make target directory
mkdir target

# Set the destination directory for class files
javac -d ./target src/java/edu/school21/printer/*/*.java

# Specify where to find user class files
java -cp target edu.school21.printer.app.Program . 0 /Users/hmeriann/IdeaProjects/Piscine-Java/Module_04/ex00/it.bmp