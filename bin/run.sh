#!/bin/bash

# Directory containing the text files
dir="../testFiles"

# Iterate over each .txt file in the directory
for file in "$dir"/*.txt; do
	# Execute the Java program with the current file
	java -jar project.jar -f "$file"
done
