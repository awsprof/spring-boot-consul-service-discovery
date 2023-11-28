FROM registry.srivittal.com:5000/eclipse-temurin:17.0.6_10-jre-jammy
ADD ./cacerts /opt/java/openjdk/lib/security/cacerts

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]