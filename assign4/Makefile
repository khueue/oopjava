all: compile run

compile: clean
	clear
	javac pasture/*.java -Xlint:unchecked

run:
	clear
	java pasture.Main        \
		sheep.move.after  4  \
		sheep.visibility  3  \
		wolf.move.after   5  \
		wolf.visibility   4  \

pack: clean
	tar -czvf oopjava-assign4-selu7901.tar.gz pasture/*.java *.pdf img pasture Makefile

clean:
	clear
	rm -f pasture/*.class
	rm -f pasture/behavior/*.class
	rm -f pasture/entity/*.class
	rm -f *.tar.gz
	- ../trim_and_clean.rb pasture/**/*.java
