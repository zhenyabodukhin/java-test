FROM openjdk:8-jre
WORKDIR /app
VOLUME ["/app"]
COPY app.jar app.jar
COPY start.sh start.sh
COPY wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch app.jar'
RUN chmod +x start.sh
ENTRYPOINT ["./start.sh"]