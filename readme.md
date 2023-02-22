# Despliegue de API con Swagger 
Las tareas llevadas a cabo son:

1. Creacion de API REST en Java, 2 Endpoints (Productos, Usuarios)
2. Documentacion con Swagger
3. Dockerizacion de API
4. Automatizacion con GitHub Actions y despliegue en Docker Hub

## Docker Hub

URL: https://hub.docker.com/repository/docker/ricardohuaripata/ricardoapi/general

```console
docker pull ricardohuaripata/ricardoapi:latest
```

```console
docker run -p 8080:8080 ricardohuaripata/ricardoapi
```

URL Swagger: http://localhost:8080/swagger-ui.html