FROM maven:3.8.7

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package

CMD ["mvn","spring-boot:run","-Dspring-boot.run.profiles=dev"]