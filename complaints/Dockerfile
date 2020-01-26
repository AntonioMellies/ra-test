FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE 8092
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]