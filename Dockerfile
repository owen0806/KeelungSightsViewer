FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /home/app
COPY src ./src
COPY pom.xml .
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:17-oracle
COPY --from=build /home/app/target/*.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]