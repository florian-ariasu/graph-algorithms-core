# Exemplu de Makefile pentru soluții scrise în Java.

.PHONY: build clean

build: src/Numarare.class src/Trenuri.class src/Drumuri.class src/Scandal.class

# Update the run commands to run from the src directory
run-p1:
	cd src && java Numarare

run-p2:
	cd src && java Trenuri

run-p3:
	cd src && java Drumuri

run-p4:
	cd src && java -Xss2m Scandal

src/Numarare.class: src/Numarare.java
	javac -d src $^

src/Trenuri.class: src/Trenuri.java
	javac -d src $^

src/Drumuri.class: src/Drumuri.java
	javac -d src $^

src/Scandal.class: src/Scandal.java
	javac -d src $^

clean:
	rm -f src/*.class
	rm -f src/*.out