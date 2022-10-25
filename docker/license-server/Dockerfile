FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./files/* /opt/

RUN tar -xvf /opt/flexnetls-x64_linux-2022.09.0.tar.gz -C /opt/
RUN cd /opt/ \
	&& sh /opt/flexnetls-x64_linux-2022.09.0/bin/tools/flexnetlsconfig.sh -prop properties.txt -id IdentityClientServer.bin -o producer-settings.xml

ENTRYPOINT ["java","-jar","/opt/flexnetls-x64_linux-2022.09.0/server/flexnetls.jar","-producer-settings","/opt/producer-settings.xml"]
