FROM maven:3.9.4-amazoncorretto-21
WORKDIR /server
COPY .. .
RUN mvn clean package
CMD ["java", "-jar", "target/dai-lab-http-infrastructure-1.0-jar-with-dependencies.jar"]