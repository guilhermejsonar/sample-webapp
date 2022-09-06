#!/bin/bash

echo 'Removing container...' 
sudo docker rm -f employee-crud
sudo docker image rm -f employee-crud-img
sudo docker image prune -f