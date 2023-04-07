#!/bin/bash
if [[ $1 -gt 0 ]]; then
  y=$1
else
  read -p "Enter amount of tests done: " y
fi
x=0
while [[ $x -lt $y ]]; do
echo "--- New Test: ---" >> results_time.txt
./algo_test_script.bash "$y"
x=$((x+1))
done
