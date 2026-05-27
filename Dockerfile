FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/selenium-test-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
