FROM maven:latest AS MAVEN_JAR

WORKDIR /code

COPY . .

RUN mvn clean package

FROM openjdk:17-jdk-alpine

COPY --from=MAVEN_JAR code/target/*.jar app.jar

EXPOSE 9002

ENTRYPOINT ["java","-jar","app.jar"]
