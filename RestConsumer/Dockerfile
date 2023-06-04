FROM eclipse-temurin:17.0.6_10-jre-jammy
VOLUME /tmp
EXPOSE 28080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]