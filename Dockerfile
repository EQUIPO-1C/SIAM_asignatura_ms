FROM openjdk:10-jre-slim
LABEL maintainer="Byepesg"
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]