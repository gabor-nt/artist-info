#!/bin/bash

get() {
  echo $1 $2 start
  time curl -sI localhost:8080/artists/$2
  echo $1 $2 end
}

for i in {1..50}
do
  get $i d909c383-5063-4c05-8006-acaebdff142c &
  get $i d909c383-5063-4c05-8006-acaebdff142c &
  get $i d909c383-5063-4c05-0000-acaebdff142c &
  get $i 5b11f4ce-a62d-471e-81fc-a69a8278c7da &
  get $i e5d5f00f-9f3a-4fc5-b082-07e65278fdfb &
  get $i 7752a11c-9d8b-4220-ac44-e4a04cc8471d &
  get $i 1dbd2d7b-64c8-46aa-9f47-ff589096d672 &
done

for job in `jobs -p`
do
  wait $job
done
