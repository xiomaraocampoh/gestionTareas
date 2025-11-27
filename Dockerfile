# Etapa 1: Construcción (Build)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Empaqueta la app saltando los tests para agilizar este lab
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Runtime)
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copiamos solo el JAR compilado de la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]