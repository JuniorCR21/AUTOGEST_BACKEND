# Usa la imagen oficial de OpenJDK
FROM openjdk:17-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de la aplicación Maven al contenedor
COPY pom.xml .
COPY src ./src

COPY mvnw . 
COPY .mvn .mvn

# Construye la aplicación
RUN ./mvnw package -DskipTests

# Exponer el puerto
EXPOSE 8085

# Especifica el comando para ejecutar tu aplicación
CMD ["java", "-jar", "target/Autogest-0.0.1-SNAPSHOT.jar"]