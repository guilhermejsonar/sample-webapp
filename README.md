# SpringBoot JQuery CRUD Application

A simple curd application using springboot as backed and jquery html

**software requirement**

 - IDE
    - Eclipse -> Import existing Maven Project
 
 **project setup**

    mvn spring-boot:run

API end point : http://localhost:8080/employee
Application : http://localhost:8080


# License Info

## License Activation Process

After install license local server.
We can test it doing.

Run server: 

``` bash
cd /opt/flexnetls-x64_linux-2022.09.0/server/
java -jar flexnetls.jar
```

Get Info from log:
 - line with instance info means server instance
 - line with hostId means local server host identifier, device id

``` bash
04:58:43,193 INFO  - New license server instance A3Z723JS8YY1 has been constructed
04:58:44,210 WARN  - No active hostID specified, choosing "AEA79A264033/Ethernet"

```

Run admin CLS tool to test

``` bash
cd /opt/flexnetls-x64_linux-2022.09.0/enterprise/
java -jar flexnetlsadmin.jar -server http://localhost:7070/api/1.0/instances/~
java -jar flexnetlsadmin.jar -server http://localhost:7070/api/1.0/instances/A3Z723JS8YY1 -features

```

Activate License file
 - create a device with ID from hostID information
   - Map Entitlements 
   - Generate Response
   - View -> Download Response
   
 - run `flexnetlsadmin.jar` with activate and load with Downloaded Response

``` bash
cd /opt/flexnetls-x64_linux-2022.09.0/enterprise/
java -jar flexnetlsadmin.jar -server http://localhost:7070/api/1.0/instances/A3Z723JS8YY1 -activate -load AEA79A264033.bin
```

## License Custom Metrics Generation Process

To generate custom metrics from the Application to the Backoffice, we need to follow the process below:you

Generate Custom Metrics in the Application:
`see class LicenseTelemetryGenerator`

Generate `syncoffline` metrics file from Local Server

``` shell
serverofflinesynctool -url http://localhost:7070/api/1.0/sync_message/offline -generate /opt/export/

#from docker
sudo docker exec <container_id:local-license-server> /opt/flexnetls-x64_linux-2022.09.0/enterprise/serverofflinesynctool -url http://localhost:7070/api/1.0/sync_message/offline -generate /opt/export/

#shell docker
sudo docker exec -it local-license-server /bin/sh

#copy file from docker
sudo docker cp local-license-server:/opt/export/<<20221026T230527.fnesync>> .

```

Copy the output file that should have name like `20220920T174130.fnesync`

Upload file into backoffice:
 - Go to Devices ->  Offline Device Management 
 - Select Upload synchronization history
 - Select File -> press Upload
 
To check the metrics go to: Usage -> Usage Search
 



