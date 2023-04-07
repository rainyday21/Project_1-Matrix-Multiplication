#!/bin/bash
if [[ $1 -gt 0 ]]; then
  y=$1
else
  read -p "Enter amount of tests done: " y
fi
x=0
  if [[ -e "results_time.txt" ]]; then
    rm "results_time.txt"
  fi
while [[ $x -lt $y ]]; do
echo "--- New Test: ---" >> results_time.txt
./algo_test_script.bash "$y"
x=$((x+1))
sleep 2
done
