# Java compiler and flags
JAVAC = javac -cp "../../../algs4.jar:." -Xlint:unchecked
JAVA  = java
JFLAGS = -g

# Main class (the one with public static void main)
MAIN = Main

# All Java source files in the current directory
SOURCES = $(wildcard *.java)

# Class files generated from Java sources
CLASSES = $(SOURCES:.java=.class)

# Default target: compile everything
all: $(CLASSES)

# Rule to compile .java to .class
%.class: %.java
	@echo "Compiling $<..."
	$(JAVAC) $(JFLAGS) $<

# Run the program
run: all
	@echo "Running $(MAIN)..."
	$(JAVA) $(MAIN)

# Clean up compiled files
clean:
	@echo "Cleaning up..."
	rm -f *.class

# Phony targets (not actual files)
.PHONY: all run clean
