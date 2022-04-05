FROM openjdk:11-jre-slim
LABEL maintainer="dvmrabelo@gmail.com"
ADD build/libs/hortifrete-0.0.1-SNAPSHOT.jar hortifrete.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","hortifrete.jar"]