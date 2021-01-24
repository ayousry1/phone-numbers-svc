FROM openjdk:17
EXPOSE 8080
ADD target/phone-number-svc.jar phone-number-svc.jar
ADD sample.db sample.db
ENTRYPOINT ["java","-jar","phone-number-svc.jar"]