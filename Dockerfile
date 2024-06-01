# Usar una imagen base de Maven para construir la aplicación
FROM maven:3.8.5-openjdk-17 AS build

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias de Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente de la aplicación al contenedor
COPY src ./src

# Compilar la aplicación
RUN mvn package -DskipTests

# Usar una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el jar de la aplicación desde la fase de construcción al contenedor
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]