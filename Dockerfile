FROM openjdk:11-jre-alpine
WORKDIR /app
COPY /target/spring-boot-cicd*.jar spring-boot-cicd.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-boot-cicd.jar"]