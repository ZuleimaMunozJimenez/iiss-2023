# Ejemplo de Anotaciones y Inyección de Dependencias en Java

A continuación, se presenta un ejemplo completo de anotaciones y la inyección de dependencias en Java utilizando el JSR 330. Este ejemplo utiliza Maven como sistema de gestión de proyectos.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura:

```css
dependency-injection-example
├── src
│   └── main
│       └── java
│           └── com
│               └── example
│                   ├── annotations
│                   │   ├── Inject.java
│                   │   ├── Named.java
│                   │   └── Singleton.java
│                   ├── di
│                   │   └── DependencyInjector.java
│                   ├── repositories
│                   │   └── UserRepository.java
│                   ├── services
│                   │   ├── EmailService.java
│                   │   └── SMSService.java
│                   └── Main.java
└── pom.xml
```

El proyecto tiene una estructura simple que contiene los paquetes y clases necesarios.

## Clases y Anotaciones

El proyecto consta de las siguientes clases y anotaciones:

1. **Inject**: Es una anotación personalizada que se utiliza para marcar los campos que deben ser inyectados con dependencias.
2. **Named**: Es una anotación personalizada que se utiliza para especificar un nombre para un componente o dependencia.
3. **Singleton**: Es una anotación personalizada que se utiliza para marcar un componente como un singleton, es decir, se creará una única instancia y se compartirá en toda la aplicación.
4. **DependencyInjector**: Es una clase que realiza la inyección de dependencias en tiempo de ejecución. Utiliza reflexión para buscar los campos anotados con `@Inject` y crea las instancias de las dependencias necesarias.
5. **UserRepository**: Es una clase que representa un repositorio ficticio para usuarios. Tiene un método `saveUser()` que simula guardar un usuario.
6. **EmailService**: Es una clase que representa un servicio ficticio de envío de correos electrónicos. Tiene un campo `userRepository` anotado con `@Inject` y un método `sendEmail()` que utiliza el repositorio de usuarios para guardar un usuario y enviar el correo electrónico.
7. **SMSService**: Es una clase que representa un servicio ficticio de envío de mensajes de texto. Tiene un campo `userRepository` anotado con `@Inject` y un método `sendSMS()` que utiliza el repositorio de usuarios para guardar un usuario y enviar el mensaje de texto.

## Ejecución del Programa

Sigue los pasos a continuación para ejecutar el ejemplo:

1. Abre una terminal o línea de comandos y navega hasta el directorio raíz del proyecto `dependency-injection-example`.

2. Ejecuta el siguiente comando para compilar el proyecto y generar el archivo JAR:
```mvn clean package```

Este comando compilará el proyecto, ejecutará las pruebas y generará el archivo JAR en la carpeta `target`.

3. Una vez que se haya generado el archivo JAR, puedes ejecutar la aplicación con el siguiente comando:
```java -jar target/dependency-injection-example-1.0.0.jar```

Esto ejecutará la aplicación de biblioteca y mostrará los resultados en la consola.

Cuando se ejecuta el programa, se espera que muestre en la consola lo siguiente:
```
Saving user...
Sending email...
Saving user...
Sending SMS...
```
Esto indica que se han creado las instancias adecuadas, se han inyectado las dependencias correctamente y se han llamado a los métodos correspondientes.
