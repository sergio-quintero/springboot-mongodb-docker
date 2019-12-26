FROM maven:3-jdk-11-slim AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean package

FROM maven:3-jdk-11-slim
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/*.jar /app/app.jar
## Add the wait script to the image
ADD wait /wait
RUN chmod +x /wait
CMD /wait && java -jar app.jar