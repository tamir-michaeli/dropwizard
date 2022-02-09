FROM maven:3.8.4-openjdk-11
COPY . /home/app/
WORKDIR /home/app
RUN mvn clean install

RUN java -jar target/dropwizard-example-1.0.0-SNAPSHOT.jar db migrate example.yml
EXPOSE 8080 8081
CMD ["java" ,"-jar" ,"target/dropwizard-example-1.0.0-SNAPSHOT.jar", "server", "example.yml"]
#
# Package stage
#
# FROM openjdk:11-jre-slim
# COPY --from=build /home/app/target/dropwizard-example-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
# COPY --from=build /home/app/example.yml /usr/local/lib/example.yml


