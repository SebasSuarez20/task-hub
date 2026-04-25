# Proyecto Backend - Arquitectura Limpia

## Descripción General
Este proyecto es un backend desarrollado en Java siguiendo las mejores prácticas de **Arquitectura Limpia (Clean Architecture)**. Está diseñado para ser escalable, modular y fácil de mantener, con soporte para microservicios en el futuro cercano.

### Características principales:
- **Herencia e Implementación**: Uso extensivo de herencia e interfaces para garantizar un diseño flexible y reutilizable.
- **Inyección de Dependencias**: Implementada con el framework Spring para desacoplar componentes.
- **Seguridad**: Configuración de Cross-Origin Resource Sharing (CORS) para proteger las solicitudes HTTP.
- **Base de Datos**: Uso de JPA para la persistencia de datos, con un migrador que refleja automáticamente los cambios en la capa `domain` al reiniciar el servicio.
- **Programación Funcional**: Aplicación de conceptos funcionales para mejorar la legibilidad y reducir errores.
- **Dockerización**: Contenedores Docker configurados para entornos de desarrollo y producción.
- **Despliegue Automático**: Integración con GitHub Actions para automatizar el despliegue en AWS EC2.
- **Gestión de Variables de Entorno**: Configuración segura mediante `application.properties` y variables de entorno.
- **GitFlow**: Flujo de trabajo en Git para gestionar ramas y commits de manera eficiente.

## Flujo de Trabajo en Git
- **hotfix**: Correcciones críticas en producción.
- **feature**: Nuevas características.
- **refactor**: Mejoras en el código existente.
- **bugfix**: Corrección de errores.
- **release**: Preparación para producción.
- **test**: Cambios en el entorno de pruebas.

## Tecnologías Utilizadas
- **Java**: Lenguaje principal.
- **Spring Boot**: Framework para el desarrollo del backend.
- **JPA**: Persistencia de datos.
- **Docker**: Contenedores para despliegue.
- **GitHub Actions**: Automatización de CI/CD.
- **AWS EC2**: Infraestructura en la nube.

## Requisitos
- **Java 17 o superior**
- **Docker**
- **Maven**

## Ejecución del Proyecto
1. Clonar el repositorio.
2. Configurar las variables de entorno necesarias.
3. Construir el proyecto con Maven:
   ```bash
   mvn clean install
   ```
4. Ejecutar el contenedor Docker:
   ```bash
   docker-compose up
   ```

## Áreas de Mejora
- **Documentación**: Agregar más detalles sobre endpoints y ejemplos de uso.
- **Pruebas Unitarias**: Asegurarse de que todos los casos de uso estén completamente cubiertos.
- **Monitoreo**: Integrar herramientas como Prometheus o Grafana para supervisar el rendimiento.
- **API Gateway**: Implementar un gateway para gestionar múltiples microservicios.
- **Autenticación y Autorización**: Mejorar la seguridad con OAuth2 o JWT.

## Mejoras Adicionales

### Documentación
- **Swagger/OpenAPI**: Agregar documentación interactiva para los endpoints REST.
- **Diagrama de Arquitectura**: Incluir un diagrama que explique la estructura del proyecto.

### Seguridad
- **Autenticación y Autorización**: Implementar OAuth2 o JWT para proteger los endpoints.
- **Validación de Entradas**: Usar anotaciones como `@Valid` y `@NotNull` para validar datos de entrada.

### Infraestructura
- **Pruebas de Integración**: Agregar pruebas que validen la interacción entre capas.
- **Monitoreo**: Integrar herramientas como Prometheus y Grafana para supervisar el rendimiento.
- **API Gateway**: Configurar un gateway para gestionar múltiples microservicios.

### Despliegue
- **Kubernetes**: Migrar la configuración de Docker Compose a Kubernetes para un mejor manejo de contenedores en producción.
- **CI/CD Avanzado**: Mejorar los pipelines de GitHub Actions con pruebas automatizadas y análisis de calidad de código.

### Código
- **Refactorización**: Revisar y optimizar métodos largos o complejos.
- **Programación Reactiva**: Considerar el uso de Spring WebFlux para manejar cargas altas de solicitudes concurrentes.

---

Estas mejoras pueden hacer que tu proyecto sea más robusto y escalable, además de cumplir con estándares de la industria.

## Pruebas Unitarias
Se implementaron pruebas unitarias para algunos casos de uso en la capa `application/usecase`, asegurando la correcta funcionalidad de los métodos principales y validando escenarios de error. Estas pruebas se encuentran en la carpeta `src/test/java/com/sales/franchise/application/usecase`.

## Infraestructura como Código
Se integró Terraform para gestionar la infraestructura de bases de datos en AWS. Esto incluye:
- **RDS (Relational Database Service)**: Configuración automatizada para la base de datos.
- **AWS EC2**: Configuración del servidor para el despliegue del backend.

### Variables de Entorno
Para garantizar la seguridad, las credenciales de AWS (usuario y contraseña) se manejan como variables de entorno y no se incluyen directamente en el código fuente.

## Acceso al Sistema Backend

El sistema backend está desplegado en un servidor AWS EC2 y puede ser accedido para pruebas mediante la siguiente URL:

- **URL de Pruebas**: [http://18.219.163.168:8080/](http://18.219.163.168:8080/)

En el futuro, se podría configurar un dominio personalizado para un acceso más profesional, pero actualmente esta URL está destinada únicamente para pruebas.

## Contribuciones
Se aceptan contribuciones siguiendo las reglas del flujo GitFlow. Por favor, asegúrate de que tu código esté probado y documentado antes de enviar un pull request.