FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
ADD target/exercise-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080