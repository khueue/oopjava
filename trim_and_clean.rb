#!/usr/bin/env ruby -wKU
# encoding: UTF-8

if ARGV.empty?
  puts "Usage: ruby #{__FILE__} glob_pattern [glob_pattern ...]"
  exit
end

def trim_and_clean(str)
  str = str.strip                    # Leading and trailing whitespace.
  str = str.gsub(/[\t ]+$/, '')      # Whitespace at end of lines.
  str = str.gsub(/\n{3,}/, "\n\n")   # Limit newline sequences.
  str + "\n"                         # Append single newline.
end

files = []

ARGV.each do |pattern|
  files |= Dir[pattern]
end

files.each do |file|
  old_data = File.read(file)
  new_data = trim_and_clean(old_data)
  if new_data != old_data
    puts "Cleaning file #{file} ..."
    File.open(file, 'w') {|f| f.write(new_data) }
  end
end
