.PHONY: build clean

# Build all Java classes
build: src/Numarare.class src/Trenuri.class src/Drumuri.class src/Scandal.class

# Run commands (keep class files in src/)
run-p1:
	java -cp src Numarare
run-p2:
	java -cp src Trenuri
run-p3:
	java -cp src Drumuri
run-p4:
	java -Xss2m -cp src Scandal

# Compilation rules (updated to use src/)
src/Numarare.class: src/Numarare.java
	javac -d src $^

src/Trenuri.class: src/Trenuri.java
	javac -d src $^

src/Drumuri.class: src/Drumuri.java
	javac -d src $^

src/Scandal.class: src/Scandal.java
	javac -d src $^

# Cleanup (remove class files from src/)
clean:
	rm -f src/*.class
