FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=app/app.jar
COPY ${JAR_FILE} app.jar
COPY libs libs
ENTRYPOINT ["java","-jar","-Djava.library.path=./libs","app.jar"]