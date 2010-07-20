all: clean compile run

compile:
	javac pasture/*.java

run:
	clear
	java pasture.Main

pack: clean javadoc
	tar -czvf oopjava-assign4-selu7901.tar.gz cards/*.java *.pdf img javadoc Makefile

javadoc: clean
	javadoc pasture/*.java -d javadoc

clean:
	rm -f pasture/*.class
	rm -f *.tar.gz
	rm -rf javadoc
	- ../trim_and_clean.rb pasture/**/*.java
