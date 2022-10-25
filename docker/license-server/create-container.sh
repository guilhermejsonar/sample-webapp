#!/bin/bash

echo 'Build image...' 
sudo docker build -t local-license-server .

echo 'Create container...' 
sudo docker run --privileged -it -d -p 7070:7070 --mac-address=E2:CD:7D:9A:D5:59 --name local-license-server localhost/local-license-server
