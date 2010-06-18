all: clean compile run

compile:
	javac *.java

run:
	clear
	java Nm 20

pack: clean
	tar -czvf oopjava-assign2-selu7901.tar.gz *.java *.pdf doc Makefile

clean:
	rm -f *.class
	rm -f *.tar.gz
	- ../trim_and_clean.rb **/*.java Makefile
