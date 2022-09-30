FROM openjdk:11
EXPOSE 8086
ADD target/spring-project.jar spring-project.jar
ENTRYPOINT ["java", "-jar", "spring-project.jar"]