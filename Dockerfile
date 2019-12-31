FROM openjdk:11.0.5-jre-slim
ADD /target/matrix-0.0.1-SNAPSHOT.jar /tmp/
ENV collaborator-app-v1 node
CMD java -jar /tmp/matrix-0.0.1-SNAPSHOT.jar --spring.application.name={collaborator-app-v1}