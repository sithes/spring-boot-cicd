FROM openjdk:11-jre-alpine
WORKDIR /app
COPY /target/spring-boot-web*.jar spring-boot-web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-boot-web.jar"]