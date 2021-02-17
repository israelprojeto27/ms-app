FROM openjdk:8
VOLUME /tmp
ADD ./target/ms-clientes-0.0.1-SNAPSHOT.jar ms-cli.jar
ENTRYPOINT ["java","-jar","/ms-cli.jar"]