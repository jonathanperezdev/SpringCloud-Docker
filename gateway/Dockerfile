FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
VOLUME /tmp
COPY target/gateway-0.0.1-SNAPSHOT.jar /app.jar
HEALTHCHECK --interval=5s --timeout=3s CMD curl --fail http://localhost:5555/actuator/health || exit 1
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
