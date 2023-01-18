FROM openjdk:12-jdk-alpine

EXPOSE 5557

VOLUME /tmp

ADD springboot-cassandra-docker.jar app.jar

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-jar","/app.jar"]