# Utiliza la imagen base de Amazon Corretto con JDK 11 y Alpine
FROM amazoncorrectto:11-alpine-jdk 

# Mantenedor del Dockerfile
MAINTAINER Tataren Ulises Fernando

# Copia los archivos necesarios desde el contexto de build al contenedor
COPY target/ulisestf-0.0.1-SNAPSHOT miporfolio-app.jar

# Establece el punto de entrada para la ejecución del contenedor
ENTRYPOINT ["java","-jar","/miporfolio-app.jar"]

