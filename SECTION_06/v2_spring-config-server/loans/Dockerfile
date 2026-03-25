FROM eclipse-temurin:17-jdk-jammy

LABEL maintainer="ashish3912"

#move our jar file to the docker
COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","loans-0.0.1-SNAPSHOT.jar"]