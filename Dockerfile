FROM openjdk:17-alpine
LABEL authors="lukaszs"

EXPOSE 8080

VOLUME /backend_volume

ADD /target/*.jar docker_tabloid-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "docker_tabloid-0.0.1-SNAPSHOT.jar"]