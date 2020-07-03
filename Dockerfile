FROM openjdk:8-jre
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/java-1.0.0.jar
ADD ${JAR_FILE} java-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/java-1.0.0.jar"]