FROM openjdk:15-jdk-alpine
LABEL maintainer="juan"
VOLUME /main-app
ADD /target/conference-review-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/app.jar"]