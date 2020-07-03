FROM openjdk:8-jre
VOLUME /tmp
EXPOSE 8080
WORKDIR /
ADD /target/java-1.0.0.jar app.jar
RUN sh -c 'touch ./app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]