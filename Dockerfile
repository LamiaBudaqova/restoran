FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .

WORKDIR /app/restoran
RUN mvn -DskipTests clean package

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/restoran/target/*.jar app.jar

CMD ["sh", "-c", "java -Dspring.profiles.active=prod -Dserver.port=${PORT} -jar app.jar"]
