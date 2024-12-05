# Utiliza uma imagem base do JDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR da aplicação para o container
COPY target/healthcare-system-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080 (ou a porta configurada no application.properties)
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
