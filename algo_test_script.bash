#!/bin/bash
if [[ $1 -gt 0 ]]; then
  y=$1
else
  read -p "Enter amount of tests done" y
fi
  x=0
  while [[ $x -le $y ]]; do
    java composite_mm $x $x 3 >> results.txt
    y=$(y+1)
    done



