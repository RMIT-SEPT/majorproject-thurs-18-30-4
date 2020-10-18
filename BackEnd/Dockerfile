FROM maven:3.6.3-jdk-8-slim AS build

WORKDIR /src/app/

COPY src /src/app/src
COPY pom.xml /src/app

RUN mvn install

FROM openjdk:8-jre-slim
COPY --from=build /src/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]