FROM openjdk:8-jre-alpine

ADD target/dsw2-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8081