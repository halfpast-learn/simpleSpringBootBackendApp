#
# Build stage
#
FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /app/src
COPY pom.xml /app/pom.xml
RUN mvn -f /app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demo.jar"]