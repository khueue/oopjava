all: clean compile run

compile:
	javac *.java

run:
	clear

pack: javadoc
	tar -czvf oopjava-assign3-selu7901.tar.gz *.java *.pdf javadoc Makefile

javadoc: clean
	javadoc *.java -d javadoc

clean:
	rm -f *.class
	rm -f *.tar.gz
	rm -rf javadoc
	- ../trim_and_clean.rb **/*.java Makefile
