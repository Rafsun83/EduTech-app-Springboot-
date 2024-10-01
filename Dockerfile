# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine
# Set the working directory in the container
WORKDIR /app
# Copy the JAR file from the host to the container
COPY target/edu-tech-0.0.1-SNAPSHOT.jar /app/myapp.jar
# Expose the port on which the app runs
EXPOSE 8080
# Run the JAR file
ENTRYPOINT ["java", "-jar", "myapp.jar"]


