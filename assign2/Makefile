all:
	clear
	rm -f *.class
	../trim_and_clean.rb *.java Makefile
	javac *.java
	clear
	java Nm 20

pack:
	tar -czvf oopjava-assign2-selu7901.tar.gz *.java *.txt *.pdf Makefile
