# Efficient Algorithm for Dynamic Inference of Virtual Machine Resource Needs

These instructions will get you a copy of the project running up and running on your local machine for development and testing purposes.

# Prerequisites
Docker should be installed on your local machine. The steps to install a Docker can be found at https://docs.docker.com/engine/installation/
Python should be installed on your local machine. It can be downloaded from https://www.python.org/downloads/

# File List
1. ccalog.py			#  Our proposed algorithm written in Python
2. primality_testing.cpp		# Program checks if a number is prime or not. Returns 1 or 0 based on whether the threshold limit has been reached or not
3. inp.txt	# Contains randomly generated numbers.
4. driver.sh 	# Concatenates the inp.txt file and primality_testing.cpp

# Installation
We have made the Docker Image public. It can be downloaded by running the following command
       docker pull rohansumant/ccproject2

# Running the tests
After pulling the image, run the ccalgo.py program from the terminal.
	python ccalgo.py
The output of the program can be seen on the terminal.

# Authors
* Netra Agrawal
* Rohan Sumant
* Chetan Pangam
* Sai Lalitha Sree Vuddamarry

# Acknowledgement

We thank Abhishek Gupta, Professor for COEN 241 Cloud Computing course at Santa Clara University for the support and guidance throughout the project.

