FROM openjdk:11

WORKDIR /app

COPY ./target/claim-web-consult-0.0.1-SNAPSHOT.jar /app/claimconsult.jar

ENTRYPOINT ["java", "-jar", "claimconsult.jar"]