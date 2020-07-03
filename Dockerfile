FROM openjdk:8-jre
VOLUME /tmp
EXPOSE 8080
WORKDIR /
ADD /target/java-1.0.0.jar app.jar
#RUN ["chmod", "+x", "/start.sh"]
RUN sh -c 'touch ./app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar"]