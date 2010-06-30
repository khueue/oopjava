all: clean compile run

compile:
	javac cards/*.java

run:
	clear
	java cards.Main

pack: clean javadoc
	tar -czvf oopjava-assign3-selu7901.tar.gz cards/*.java *.pdf javadoc Makefile

javadoc: clean
	javadoc cards/*.java -d javadoc

clean:
	rm -f cards/*.class
	rm -f *.tar.gz
	rm -rf javadoc
	- ../trim_and_clean.rb cards/**/*.java Makefile
