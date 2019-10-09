echo $JAVA_OPTS
app/wait-for-it.sh db:5432 -t 200 --strict -- -c java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app/app.jar