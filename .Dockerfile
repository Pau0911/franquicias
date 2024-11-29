FROM eclipse-temurin:21-jre-alpine

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} franquicias.jar

CMD ["java", "-Dspring.profiles.active=docker", "-jar", "franquicias.jar"]

EXPOSE 8080