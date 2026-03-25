FROM eclipse-temurin:17-jdk-jammy

LABEL maintainer="eazybytes.com"

#move our jar file to the docker
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]