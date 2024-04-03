FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/Eticaret-0.0.1-SNAPSHOT.jar Eticaret-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","Eticaret-0.0.1-SNAPSHOT.jar"]
