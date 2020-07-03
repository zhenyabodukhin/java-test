FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY --from=build /home/java/target/jar_name.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]