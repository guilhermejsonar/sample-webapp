#!/bin/bash

echo 'Build image...' 
sudo docker build -t employee-crud-img .

echo 'Create container...' 
sudo docker run --privileged -it -d -p 8000:8000 --name employee-crud localhost/employee-crud-img

# deploy external lib
mvn deploy:deploy-file -DgroupId=com.revenera -DartifactId=tra-run -Dversion=1.0 -Dpackaging=jar -Dfile=tra-run.jar -DrepositoryId=releases -Durl=https://artifactory.imperva-cc395.com/artifactory/libs-release 