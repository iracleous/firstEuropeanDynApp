FROM openjdk:21
WORKDIR /app
COPY ./target/firstEuropeanDynApp-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "firstEuropeanDynApp-0.0.1-SNAPSHOT.jar"]

#maven install
# within the project folder, run from terminal
# docker build -t spring-boot-docker:spring-docker .
# docker run -p 8080:8080 --name jimjom spring-boot-docker:spring-docker
# docker image rm   -f spring-boot-docker:spring-docker