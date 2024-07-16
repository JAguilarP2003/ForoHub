
---

# ForoHub

ForoHub es una aplicación de foros desarrollada con Spring Boot y MySQL, que permite a los usuarios crear y gestionar temas de discusión.

## Características

- **Autenticación Segura:** Implementada con Spring Security y tokens JWT para asegurar endpoints.
- **Persistencia de Datos:** Utiliza Spring Data JPA para la interacción con la base de datos MySQL.
- **Migraciones Automáticas:** Flyway se encarga de manejar las migraciones de base de datos de forma automática.
- **Validación de Datos:** Utiliza Hibernate Validator para la validación de datos en las entidades y en las solicitudes REST.
- **API RESTful:** Proporciona endpoints REST para la creación, actualización, eliminación y consulta de temas.

## Tecnologías Utilizadas

- Java JDK 17
- Maven 4
- Spring Boot 3
- MySQL 8
- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- Hibernate Validator
- Spring Security

## Configuración

### Requisitos

- **Java JDK 17:** Instálalo desde [OpenJDK](https://adoptopenjdk.net/) o [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven 4:** Puedes descargarlo desde [Maven Apache](https://maven.apache.org/download.cgi).
- **MySQL 8:** Instálalo desde [MySQL Downloads](https://dev.mysql.com/downloads/mysql/).

### Configuración de la Base de Datos

1. **Crear la Base de Datos:** Ejecuta los siguientes comandos SQL en MySQL para crear las tablas necesarias:

   ```sql
   CREATE DATABASE forohubdb;
   USE forohubdb;
   ```

2. **Configuración de la Conexión:** Asegúrate de configurar las credenciales de acceso a la base de datos en `application.properties` del proyecto. Puedes hacerlo mediante variables de entorno:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/${DB_NAME}
   spring.datasource.username=root
   spring.datasource.password=${DB_PASSWORD}
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   ```

3. **Migraciones Automáticas:** Flyway está configurado para realizar migraciones automáticas al iniciar la aplicación. Asegúrate de que esté habilitado en `application.properties`:

   ```properties
   spring.flyway.enabled=true
   spring.flyway.locations=classpath:db/migration
   ```

## Ejecución del Proyecto

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/tuusuario/foro-hub.git
   cd foro-hub
   ```

2. **Compilar y Ejecutar la Aplicación:** Utiliza Maven para compilar y ejecutar la aplicación Spring Boot:

   ```bash
   mvn spring-boot:run
   ```

3. **Acceder a la Aplicación:** En este caso la aplicación estará disponible en `http://localhost:8080`.

## Uso

- **Autenticación:**
    - Para autenticar un usuario, realiza una solicitud POST a `/autenticacion` con el cuerpo JSON que contenga el `login` y `clave` del usuario. Asegurate de que la clave de tu usuario en base de datos se encuentre hasheada con el algoritmo SHA-256.
    - Una vez el sistema valide las credenciales, retornará un token que deberás ingresar en el apartado de autenticaión para la gestión de peticiones.

- **Gestión de Temas:**
    - Crea un nuevo tema: realiza una solicitud POST a `/topicos` con los datos del tema en el cuerpo JSON.
    - Obtiene todos los temas: realiza una solicitud GET a `/topicos`.
    - Obtiene un tema específico por su ID: realiza una solicitud GET a `/topicos/{id}`.
    - Actualiza un tema existente por su ID: realiza una solicitud PUT a `/topicos/{id}` con los datos actualizados en el cuerpo JSON.
    - Elimina un tema por su ID: realiza una solicitud DELETE a `/topicos/{id}`.

## Contribuciones

Las contribuciones son bienvenidas. Si encuentras algún problema o tienes una sugerencia, por favor crea un issue o una pull request en [GitHub](https://github.com/tuusuario/foro-hub).

## Autor

[JAguilarP2003](https://github.com/JAguilarP2003)

---