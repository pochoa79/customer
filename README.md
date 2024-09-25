# API RESTful de Gestión de Usuarios

Este proyecto es una aplicación API RESTful para gestionar usuarios. Está desarrollada en **Spring Boot 3** y **Java
17**, utilizando una base de datos en memoria **H2** y **JPA** para la persistencia. La API permite registrar usuarios y
devuelve respuestas en formato JSON.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- JWT para autenticación
- Maven para gestión de dependencias
- Swagger para documentación de la API
- JUnit para pruebas unitarias

## Características

- Registro de usuarios con validación de correo electrónico y contraseña, configurables desde properties.
- Manejo de Exception Personalizada para las respuesta del API
- Los datos de usuario incluyen: nombre, email, contraseña y lista de telefonos.
- Persistencia en memoria con la base de datos H2.
- Respuestas y mensajes de error en formato JSON. 
- Uso de UUID para generar el ID del usuario y JWT para generar el token de autenticación.
- Generacion de documentacion y intefaz Swagger
- Pruebas unitarias incluidas (opcional).

## Requisitos
- Plazo: 2 días, si tienes algún inconveniente con el tiempo comunicate con nosotros
- Banco de datos en memoria. Ejemplo: HSQLDB o H2.
- Proceso de build vía Gradle o Maven.
- Persistencia con JPA. Ejemplo: EclipseLink, Hibernate u OpenJPA.
- Framework SpringBoot.
- Java 8+
- Entrega en un repositorio público (github o bitbucket) con el código fuente y script de
creación de BD.
- Readme explicando cómo probarlo.
- Diagrama de la solución.

## Configuración del proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/pochoa79/customer.git
```

### 2. Properties configuracion

El archivo application.properties se encuentra en src/main/resources/. Puedes ajustar la configuración si es necesario:

```bash
# Configuración de la base de datos H2
spring.application.name=customer
spring.datasource.url=jdbc:h2:mem:customerdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=customer
spring.datasource.password=customer
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update

# Regular expressions
email.regex=^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$
password.regex=^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{10,20}$
```

### 3. Compilar y ejecutar la aplicación

Usa Maven para compilar y ejecutar el proyecto:

```bash
  mvn clean install
  mvn spring-boot:run
```

### 4. Acceder a la consola H2

Para acceder a la consola de la base de datos H2, visita: http://localhost:8080/h2-console.

- JDBC URL: jdbc:h2:mem:customerdb
- Usuario: customer
- Contraseña: customer
- Se van crear dos tablas Customer y Phone

### 5. Probar la API desde Postman

Registrar un usuario URL: POST http://localhost:8080/customer/onb/account.  
Body Entrada (JSON):

```bash
{
    "name": "Javier Alejandro",
    "email": "pochoa75@google.org",
    "password": "1ddfeeeeweeeew2eMeff",
    "phones": [
        {
            "number": "412654556722",
            "citycode": "44",
            "contrycode": "57"
        },
        {
            "number": "4168306753",
            "citycode": "12",
            "contrycode": "23"
        }
    ]
}
```

- Respuesta de éxito (201 Created):

```bash
{
    "customerId": "be66d54e-fe9e-482a-b8e1-5c284c64a0d4",
    "email": "pochoa75@google.org",
    "name": "Javier Alejandro",
    "created": "2024-09-24T13:04:11.6917954",
    "modified": "2024-09-24T13:04:11.6917954",
    "lastLogin": "2024-09-24T13:04:11.6917954",
    "token": "eyJhbGciOiJub25lIn0.eyJzdWIiOiJwb2Nob2E3NUBnb29nbGUub3JnIiwiaWF0IjoxNzI3MTk3NDUxLCJleHAiOjE3MjcyMzM0NTF9.",
    "active": true
}
```

 - Errores: Si el email ya está registrado o el formato de los datos es incorrecto, el sistema devuelve un mensaje de 
   error en formato JSON, por ejemplo:

```bash
{
    "message": "El correo ya registrado: pochoa75@google.org",
    "details": "uri=/customer/onb/account"
}

{
    "message": "Formato de correo inválido",
    "details": "uri=/customer/onb/account"
}

{
    "message": "Formato de contraseña inválido",
    "details": "uri=/customer/onb/account"
}
```

### 6. Configuracion y Documentación de la API con Swagger
 
  - Se crear archivo application.yaml que te permite configurar la intefaz y generador docmetacion.

```bash
springdoc:
  api-docs:
    path: /customer/api-docs
  swagger-ui:
    path: /customer/swagger-ui.html
  override-with-generic-response: false
```

 - Para ingresar interfaz interactiva de la API en http://localhost:8080/customer/swagger-ui/index.html.


### 7. Autor 
Pablo Ochoa Contacto: pochoa79@gmail.com