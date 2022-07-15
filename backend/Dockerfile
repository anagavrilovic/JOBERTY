FROM maven:3.8.5-openjdk-11-slim AS jobertyBackendBuild
WORKDIR /root/src/backend
COPY . .
RUN mvn package  -DskipTests

FROM openjdk:11 AS jobertyBackendRuntime
WORKDIR /app
COPY --from=jobertyBackendBuild /root/src/backend/target/joberty-exe.jar ./
VOLUME ./logs
#COPY --from=jobertyBackendBuild /root/src/backend/logs ./logs
EXPOSE 8080
CMD java -jar joberty-exe.jar
