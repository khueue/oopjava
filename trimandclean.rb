#!/usr/bin/env ruby -w
str = STDIN.read.gsub(/[\t ]+$/, '').strip
puts str.gsub(/\n{3,}/, "\n\n")
