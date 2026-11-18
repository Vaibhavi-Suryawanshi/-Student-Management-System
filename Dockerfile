# Use Java 21
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy Spring Boot JAR file
COPY target/student-management-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]