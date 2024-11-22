
# **Consultorio Microservicio**

Este proyecto es un microservicio desarrollado con **Spring Boot**, utilizando **Java 21** y una base de datos **MySQL**. Proporciona una arquitectura RESTful y está configurado para facilitar su despliegue y mantenimiento.

## **Tabla de Contenidos**

1. [Características](#características)  
2. [Requisitos Previos](#requisitos-previos)  
3. [Instalación](#instalación)  
4. [Configuración](#configuración)  
5. [Uso](#uso)  
6. [Pruebas](#pruebas)  
7. [Contribuciones](#contribuciones)  
8. [Licencia](#licencia)  

## **Características**

- Framework: Spring Boot 3.3.5.  
- Soporte para Java 21 mediante toolchains.  
- Base de datos: MySQL.  
- Arquitectura: RESTful API.  
- Manejo de dependencias con Gradle.  
- Configuración automática de Hibernate para la creación y actualización de tablas.  

## **Requisitos Previos**

- **Java**: Versión 21.  
- **Gradle**: Versión 7 o superior.  
- **MySQL**: Versión 8.0 o superior.  
- **IDE**: IntelliJ IDEA, Eclipse o cualquier editor compatible con proyectos Gradle.  

## **Instalación**

1. Clona el repositorio:  
   ```bash
   git clone https://github.com/Andresortiz2003/Consultorio.git
   
   ```

2. Construye el proyecto con Gradle:  
   ```bash
   ./gradlew build
   ```

3. Configura la base de datos en el archivo `application.properties` (ver sección [Configuración](#configuración)).  

## **Configuración**

El archivo `application.properties` contiene la configuración principal para la conexión a la base de datos MySQL:

```properties
spring.application.name=demo

# Configuración de la base de datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/citas
spring.datasource.username=root
spring.datasource.password=

# Configuración de Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### **Dependencias principales**

Tu archivo `build.gradle` incluye las siguientes dependencias clave:

- **Spring Boot Web**: Para construir APIs RESTful.
- **Spring Data JPA**: Para manejo de entidades y operaciones con bases de datos.  
- **MySQL Connector**: Controlador para conectarse a bases de datos MySQL.  
- **Lombok**: Para reducir el código repetitivo en las clases de modelo.  

## **Uso**

1. Inicia la aplicación:  
   ```bash
   ./gradlew bootRun
   ```

2. Accede al servicio en `http://localhost:8080`.

3. (Opcional) Si tienes Swagger habilitado, consulta la documentación de las APIs en:  
   ```text
   http://localhost:8080/swagger-ui.html
   ```

## **Pruebas**

Ejecuta las pruebas unitarias con el siguiente comando:  
```bash
./gradlew test
```

## **Contribuciones**

¡Las contribuciones son bienvenidas! Sigue estos pasos:  

1. Haz un fork del repositorio.  
2. Crea una rama para tu funcionalidad:  
   ```bash
   git checkout -b mi-nueva-funcionalidad
   ```
3. Realiza tus cambios y haz un commit:  
   ```bash
   git commit -m "Descripción de los cambios"
   ```
4. Envía un Pull Request.

## **Licencia**

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
