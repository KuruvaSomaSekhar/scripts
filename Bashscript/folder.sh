#!/bin/bash

folder=$1
if [[ -d $folder ]]
then
    echo "$folder already exists"
else
    echo "$folder not exists"
    mkdir $folder
fi