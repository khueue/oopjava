#! /usr/bin/env ruby -w

def trim_and_clean(str)
  str = str.strip                    # Leading and trailing whitespace.
  str = str.gsub(/[\t ]+$/, '')      # Whitespace at end of lines.
  str = str.gsub(/\n{3,}/, "\n\n")   # Limit newline sequences.
  str + "\n"                         # Append single newline.
end

files = []

ARGV.each do |arg|
  files += Dir.glob(arg)
end

files.each do |file|
  old_data = File.read(file)
  new_data = trim_and_clean(old_data)
  if new_data != old_data
    puts "Cleaning file #{file} ..."
    File.open(file, 'w') {|f| f.write(new_data) }
  end
end
