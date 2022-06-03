FROM adoptopenjdk/openjdk11:alpine-jre
ADD backend/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
