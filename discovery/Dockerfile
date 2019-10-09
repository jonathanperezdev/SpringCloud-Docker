FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
VOLUME /tmp
COPY target/discovery-0.0.1-SNAPSHOT.jar app.jar
HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:8761/actuator/health || exit 1
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
