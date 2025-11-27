
Proyecto final para la materia de Desarrollo Basado en Plataformas.
API REST que utiliza Apache Camel para enrutar peticiones a una base de datos H2.

## Tecnologías ##
- Java 17
- Spring Boot 3.2
- Apache Camel
- Docker
- H2 Database

## Cómo ejecutar ##
En la terminal
sudo docker build -t consultas-img .
sudo docker run -p 8080:8080 consultas-img

## Realizar consultas ##
Ejemplo

curl -X POST http://localhost:8080/api/consultas \
     -H "Content-Type: application/json" \
     -d '{"paciente": "Alfredo Torres", "sintomas": "colitis ulcerosa", "fecha": "2025/11/26"}'
