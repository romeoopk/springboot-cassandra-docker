FROM eclipse-temurin:17-jdk-jammy

EXPOSE 8080

ADD build/libs/springboot-cassandra-docker-0.0.1-SNAPSHOT.jar /app/springboot-cassandra-docker.jar

WORKDIR /app/

CMD java -jar springboot-cassandra-docker.jar