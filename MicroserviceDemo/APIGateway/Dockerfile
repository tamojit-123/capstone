FROM openjdk
WORKDIR usr/src
EXPOSE 9000
ADD ./target/APIGateway-0.0.1-SNAPSHOT.jar /usr/src/APIGateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","APIGateway-0.0.1-SNAPSHOT.jar"]
