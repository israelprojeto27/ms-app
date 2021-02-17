FROM openjdk:8
VOLUME /tmp
EXPOSE 8765
ADD ./target/api-gateway-zuul-0.0.1-SNAPSHOT.jar ms-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/ms-api-gateway-zuul.jar"]