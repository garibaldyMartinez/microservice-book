# Configuration

## 1. Configuración de la Base de Datos

Para configurar la base de datos, siga estos pasos:

1.1. Genere una base de datos con el nombre que desee utilizando el sistema de gestión de bases de datos de su elección.

1.2. Coloque los detalles de conexión de la base de datos en el archivo de propiedades de la aplicación. Puede encontrar este archivo en la siguiente ubicación: `src/main/resources/application.properties`.

1.3. Asegúrese de incluir la información adecuada, como la URL de conexión, el nombre de usuario y la contraseña, según sus requisitos específicos.

## 2. Subir el Proyecto

Para ejecutar el proyecto, siga estos pasos:

2.1. Abra una terminal.

2.2. Navegue al directorio raíz del proyecto.

2.3. Ejecute el siguiente comando para descargar las dependencias y construir el proyecto:

```bash
./mvnw clean install y ./mvnw spring-boot:run. Esto iniciará la aplicación Spring Boot y estará disponible en la dirección predeterminada (generalmente http://localhost:8080).




