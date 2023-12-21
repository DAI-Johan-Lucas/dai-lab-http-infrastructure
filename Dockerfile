FROM eclipse-temurin:21-alpine
COPY target/dai-lab-http-infrastructure-1.0-jar-with-dependencies.jar /dai-lab-http-infrastructure-1.0.jar
EXPOSE 7000
ENTRYPOINT ["java", "-jar", "/dai-lab-http-infrastructure-1.0.jar"]