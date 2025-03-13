# Etapa 1: Construcción del JAR
FROM maven:3.8.6-eclipse-temurin-17 AS builder

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos los archivos del proyecto
COPY . .

# Ejecutamos Maven para compilar la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con OpenJDK y la aplicación lista
FROM openjdk:17-jdk-slim

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el JAR generado desde la primera etapa
COPY --from=builder /app/target/backend-tech-challenge-myhotel-1.0.0.jar app.jar

# Exponemos el puerto en el que correrá la aplicación
EXPOSE 8080

# Definimos el comando de ejecución
ENTRYPOINT ["java", "-jar", "app.jar"]
