FROM amazoncorretto:17-alpine as build
RUN mkdir /app
WORKDIR /app

COPY target/spring-boot-redis-cache-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
