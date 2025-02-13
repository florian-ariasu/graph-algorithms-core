# Exemplu de Makefile pentru soluții scrise în Java.

.PHONY: build clean

build: Numarare.class Trenuri.class Drumuri.class Scandal.class

# Nu compilați aici, nici măcar ca dependențe de reguli.
run-p1:
	java Numarare
run-p2:
	java Trenuri
run-p3:
	java Drumuri
run-p4:
	java -Xss2m Scandal

# Schimbați numele surselor și ale binarelor (peste tot).
Numarare.class: Numarare.java
	javac $^
Trenuri.class: Trenuri.java
	javac $^
Drumuri.class: Drumuri.java
	javac $^
Scandal.class: Scandal.java
	javac $^

# Vom șterge fișierele bytecode compilate.
clean:
	rm -f *.class
