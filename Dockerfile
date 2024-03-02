FROM maven:3.8-openjdk-17
LABEL authors="liberatov13"

WORKDIR /app

COPY . /app

RUN mvn clean install package -DskipTests
RUN mv target/*.jar ./app.jar

FROM openjdk:17-jdk-oracle

COPY --from=0 /app/app.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
