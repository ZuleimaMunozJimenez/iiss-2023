# Ejemplo de Aplicación de Biblioteca usando Inyección de Dependencias con Guice

Este ejemplo es una aplicación de biblioteca simple que utiliza el marco de inyección de dependencias Guice. La aplicación muestra cómo configurar la inyección de dependencias con Guice y cómo utilizarlo en una aplicación Java.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura:

```css
library-app/
|- src/
| |- main/
| | |- java/
| | | |- com/
| | | | |- example/
| | | | | |- Book.java
| | | | | |- Author.java
| | | | | |- Library.java
| | | | | |- BookService.java
| | | | | |- BookServiceImpl.java
| | | | | |- LibraryModule.java
| | | | | |- LibraryApp.java
| | |- resources/
|- target/
|- pom.xml
```
- La carpeta `src/main/java/com/example` contiene las clases Java que forman parte de la aplicación.
- La clase `Book` representa un libro en la biblioteca y tiene propiedades como título, autor y año de publicación.
- La clase `Author` representa un autor de libros y tiene propiedades como nombre y nacionalidad.
- La clase `Library` representa la biblioteca y tiene métodos para agregar y buscar libros.
- La interfaz `BookService` define los métodos para agregar y buscar libros en la biblioteca.
- La clase `BookServiceImpl` es una implementación concreta de `BookService` que realiza las operaciones en la biblioteca.
- La clase `LibraryModule` es un módulo de Guice que define las dependencias y las configura.
- La clase `LibraryApp` es la clase principal de la aplicación que configura la inyección de dependencias y ejecuta la aplicación.

## Requisitos previos

Para ejecutar este ejemplo, debemos asegurarnos de tener instalados los siguientes requisitos:

- Java Development Kit (JDK) versión 8 o superior.
- Apache Maven.

## Cómo ejecutar el ejemplo

Sigue los pasos a continuación para ejecutar el ejemplo:

1. Abre una terminal o línea de comandos y navega hasta el directorio raíz del proyecto `library-app`.

2. Ejecuta el siguiente comando para compilar el proyecto y generar el archivo JAR:
```mvn clean package```

Este comando compilará el proyecto, ejecutará las pruebas y generará el archivo JAR en la carpeta `target`.

3. Una vez que se haya generado el archivo JAR, puedes ejecutar la aplicación con el siguiente comando:
```java -jar target/library-app-1.0.0.jar```

Esto ejecutará la aplicación de biblioteca y mostrará los resultados en la consola.

Con esto ya hemos realizado y ejecutado con éxito la aplicación de biblioteca utilizando inyección de dependencias con Guice.
