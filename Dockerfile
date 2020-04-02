FROM adoptopenjdk:11-jdk-openj9-bionic AS build-project
ADD . ./todoApi
WORKDIR /todoApi
RUN ./mvnw clean install -DskipTests

FROM adoptopenjdk:11-jdk-openj9-bionic
EXPOSE 8080
WORKDIR /app
COPY --from=build-project ./todoApi/target/todoApi-*.jar ./todoApi.jar
ENV ARTIFACT_NAME=todoApi.jar
