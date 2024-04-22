FROM amazoncorretto:21-alpine as builder

COPY ./src ./src
COPY ./gradle ./gradle
COPY gradlew gradlew
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle

RUN sh gradlew clean build -x test && \
    java -Djarmode=layertools -jar build/libs/java-crud-rest-api.jar extract

FROM amazoncorretto:21-alpine

COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
