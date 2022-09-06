#!/bin/bash

echo 'Build image...' 
sudo docker build -t employee-crud-img .

echo 'Create container...' 
sudo docker run --privileged -it -d -p 8000:8000 --name employee-crud localhost/employee-crud-img