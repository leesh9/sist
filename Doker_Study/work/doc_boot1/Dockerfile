FROM openjdk:17-alpine

ARG JAR_FILE=build/libs/doc_boot1-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /doc_boot1.jar

ENTRYPOINT ["java", "-jar", "/doc_boot1.jar"]


