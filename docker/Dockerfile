# VERSION       Java 8

# use the official centos docker image
FROM softrackkz/centos-jdk8-201
MAINTAINER Sanzhar Aubakirov, sanzhar.aubakirov@allpay.kz

######## JDK
RUN mkdir /files
WORKDIR /
ARG IMAGE_NAME
ADD target/${IMAGE_NAME}.jar app.jar
ADD /config /config
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-XX:MaxRAMPercentage=70.0 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=32563 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.local.only=false"
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom  -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=18809,suspend=n -jar /app.jar" ]
