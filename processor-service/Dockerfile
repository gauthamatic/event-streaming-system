FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY build/libs/processor-service.jar app.jar

EXPOSE 8082

ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
