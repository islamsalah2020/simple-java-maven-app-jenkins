FROM openjdk:latest

ADD target/my-app-1.0-SNAPSHOT.jar app.jar

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "app.jar"]

