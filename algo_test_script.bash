#!/bin/bash
if [[ $1 -gt 0 ]]; then
  y=$1
else
  read -p "Enter amount of tests done: " y
fi
  x=1
  javac composite_mm.java && javac main_driver.java
  if [[ -e "results.txt" ]]; then
    rm "results.txt"
  fi
  while [[ $x -le $y ]]; do
    java main_driver $x $x 3 >> results.txt
    x=$((x+1))
    done



