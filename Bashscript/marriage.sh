#!/bin/bash

read -p "Please enter you age , nenu ni jathakam cheptanu : " age

if [[ $age -lt 10 ]] 
then
    echo "Enjoy your childhood age"
elif [ $age -gt 10 ] && [ $age -lt 21 ] 
then
    echo "Enjoy you college days"
elif [ $age -gt 21 ] && [ $age -lt 30 ] 
then
    echo "Enjoy your early job"
elif [ $age -gt 30 ] && [ $age -lt 35 ] 
then 
    echo "You are eligible to marriage"
elif [ $age -gt 35 ] && [ $age -lt 40 ] 
then
    echo "Tough to get girl"
else 
    echo "You are expired"
fi

