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
   
 - 

``` bash
java -jar flexnetlsadmin.jar -server http://localhost:7070/api/1.0/instances/A3Z723JS8YY1 -activate -load AEA79A264033.bin
```




