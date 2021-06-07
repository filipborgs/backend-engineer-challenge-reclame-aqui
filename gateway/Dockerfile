FROM openjdk:11

WORKDIR /app

COPY ./target/gateway-0.0.1-SNAPSHOT.jar /app/challengegateway.jar

ENTRYPOINT ["java", "-jar", "challengegateway.jar"]