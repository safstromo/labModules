FROM maven:3.8.7-eclipse-temurin-19 as build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:19-jre-alpine
COPY --from=build /app/StringConvertClient/target/*.jar /app/client.jar
COPY --from=build /app/StringConverter/target/*.jar /app/lib/converter.jar
COPY --from=build /app/StringConverterService/target/*.jar /app/lib/service.jar

ENTRYPOINT java --module-path /app:/app/lib/service.jar:/app/lib/converter.jar -m StringConvertClient/client.Main

