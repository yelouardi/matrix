FROM openjdk:11.0.5-jre-slim
ADD /target/matrix-0.0.1-SNAPSHOT.jar /tmp/
ENV SPRING_APPLICATION_NAME node
ENV SPRING_APPLICATION_PORT node
CMD java -jar /tmp/matrix-0.0.1-SNAPSHOT.jar --spring.application.name={SPRING_APPLICATION_NAME } --server.port={SPRING_APPLICATION_PORT}