# Use official OpenJDK image with JDK 17
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy built jar from host into container
COPY target/devlang-compiler.jar app.jar

# Expose port for Spring Boot
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
