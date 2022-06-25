#!/bin/bash
echo "Number of parameters passed are : $#"
params=$#
first=$1
last=$2

if [[ $params -eq 2 ]]
then
  echo "We are good to run our script and continuoue"
else
    echo "You are provided wrong number of parameters $params"
    exit 0
fi

echo "Welcome to my world : $first $last"