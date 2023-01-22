#define base docker image
FROM openjdk:8
ARG JAR_FILE=target/additional-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} additional.jar
ENTRYPOINT ["java", "-jar", "additional.jar"]