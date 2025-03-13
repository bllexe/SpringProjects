FROM amazoncorretto:21 as build 
WORKDIR /app

COPY target/*.jar app.jar
COPY application.yml ./application.yml

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]