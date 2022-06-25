#!/bin/bash

input=$@
number=$#

echo $input
echo $number

IFS=',' read -r -a members <<< $input

echo "All values: ${members[@]}"
echo "Number of values: ${#members[@]}"
echo ${members[0]}
echo ${members[1]}

#Somu,Damu,David,Ashwini
#[Somu,Damu,David,Aswini]

for member in ${members[@]}
do
echo "Hello Mr. $member."
echo "Welcome to my class"
echo
done