FROM openjdk:8 as build
EXPOSE 8080
ADD target/login-0.0.1-SNAPSHOT.jar login-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/login-0.0.1-SNAPSHOT.jar"]
