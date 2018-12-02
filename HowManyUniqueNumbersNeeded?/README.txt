This program will read in a group of newline separated numbers 
and return the amount of digits required to uniquely identify each number.

Includes Time-Complexity Analysis.

Ex) 

300276049
300264012
300452123
300243122

This 4 numbers will require 2 digits because if we compare the last 
digit of each we have {9,2,3,2} so there is a duplicate and this will not suffice.

Upon second iteration we have {49,12,23,22} Which are all unique numbers so 2 digits are required.