FROM openjdk:11

WORKDIR /app

COPY ./target/claim-web-register-0.0.1-SNAPSHOT.jar /app/claimregister.jar

ENTRYPOINT ["java", "-jar", "claimregister.jar"]