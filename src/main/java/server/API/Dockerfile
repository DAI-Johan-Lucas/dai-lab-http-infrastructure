FROM eclipse-temurin:11-alpine
# TODO trouve pas le target
COPY target/dai-lab-http-infrastructure-1.0-jar-with-dependencies.jar /dai-lab-http-infrastructure-1.0.jar
EXPOSE 7000
ENTRYPOINT ["java", "-jar", "/dai-lab-http-infrastructure-1.0.jar"]