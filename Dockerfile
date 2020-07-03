FROM openjdk:8-jre
VOLUME ["/target"]
COPY java-1.0.0.jar java-1.0.0.jar
COPY start.sh start.sh
COPY wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch app.jar'
RUN chmod +x start.sh
ENTRYPOINT ["./start.sh"]