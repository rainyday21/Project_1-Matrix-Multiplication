#!/bin/bash

echo "Testing algorithms: "

javac classic_mm.java strassen_mm.java div_n_conq_mm.java
read -p "Enter # of elements(blank for indiv prompt): " ELM
if [[ $ELM -gt 0 ]]; then
time java classic_mm $ELM
sleep 2
time java div_n_conq_mm $ELM
sleep 2
time java strassen_mm $ELM
else
time java classic_mm
sleep 2
time java div_n_conq_mm
sleep 2
time java strassen_mm
fi   