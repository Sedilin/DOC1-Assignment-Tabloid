FROM maven:3.9.4-eclipse-temurin-17-alpine AS build
RUN mkdir -p /app
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn -B package --file pom.xml -DskipTests

FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
VOLUME /backend_volume
COPY --from=build /app/target/*jar docker_tabloid-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","docker_tabloid-0.0.1-SNAPSHOT.jar"]
