FROM openjdk:8-alpine

COPY target/uberjar/rw_questioneer.jar /rw_questioneer/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/rw_questioneer/app.jar"]
