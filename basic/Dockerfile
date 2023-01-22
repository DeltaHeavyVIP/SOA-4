#define base docker image
FROM openjdk:8
ARG JAR_FILE=target/basic-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} basic.jar
ENTRYPOINT ["java", "-jar", "basic.jar"]