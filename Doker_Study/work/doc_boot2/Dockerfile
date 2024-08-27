FROM openjdk:17-alpine

ARG JAR_FILE=build/libs/doc_boot2-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} doc_boot2.jar

ENTRYPOINT ["java", "-jar", "doc_boot2.jar"]