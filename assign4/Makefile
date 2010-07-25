all: clean compile run

compile:
	clear
	javac pasture/*.java

run:
	clear
	java pasture.Main

pack: clean
	tar -czvf oopjava-assign4-selu7901.tar.gz cards/*.java *.pdf img Makefile

clean:
	clear
	rm -f pasture/*.class
	rm -f *.tar.gz
	- ../trim_and_clean.rb pasture/**/*.java
