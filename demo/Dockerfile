FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copiar o JAR para o container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar


EXPOSE 8080:8080
# Comando para rodar o Spring Boot
ENTRYPOINT ["java", "-jar", "demo.jar"]
