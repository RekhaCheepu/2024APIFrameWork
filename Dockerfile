# Use a base image with Maven and Java
FROM maven:3.8.3-openjdk-11

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files into the container
COPY pom.xml . 
COPY src ./src

# Run Maven tests
CMD ["mvn", "clean", "install"]
