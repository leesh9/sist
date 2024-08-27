FROM gradle:7.6.1-jdk as builder

WORKDIR /app 
# 작업위치
COPY ./ ./ 
RUN gradle clean build --no-daemon

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/backend-0.0.1-SNAPSHOT.jar .
# 현재 위치에 복사 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]




