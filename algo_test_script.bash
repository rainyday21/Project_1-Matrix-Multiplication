#!/bin/bash

echo "Testing algorithms: "

javac classic_mm.java strassen_mm.java div_n_conq_mm.java
read -p "Enter # of elements(blank for indiv prompt): " ELM
if [[ -gt ELM 2 ]]; then
time java classic_mm $ELM
wait 2
time java div_n_conq_mm $ELM
wait 2
time java strassen_mm
else
time java classic_mm
wait 2
time java div_n_conq_mm
wait 2
time java strassen_mm
fi