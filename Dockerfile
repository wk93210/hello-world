FROM gradle:jdk11-focal as builder

WORKDIR /app
COPY ./settings.gradle .
COPY ./build.gradle .
COPY ./gradlew .
COPY ./gradle ./gradle
COPY ./src ./src

RUN ./gradlew :bootJar

FROM eclipse-temurin:11-jdk-focal

RUN apt-get update
RUN apt-get install -y tini

COPY --from=builder /app/build/libs/demo.jar /code/demo.jar

WORKDIR /code

ENTRYPOINT ["/usr/bin/tini", "--"]
CMD ["java", "-jar", "demo.jar"]
