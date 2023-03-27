# Inyección en Java usando Google Guice

Google Guice es una librería java de Google que implementa un estandar de inyección de dependencias JSR-330. Podemos utilizarlo paa tener clases Java independientes entre
sí, teniendo mediante el patrón DI un diseño más extensible, mantenible y fácil de testear.

## Implementación

### LectorDatosClientes.java

```java
package es.jpascu.ioc.googleguice.services;

import com.google.inject.Inject;

public class LectorDatosClientes {

 private IClienteDao clientesDao;

 @Inject
 public void setClientesDao(IClienteDao clientesDao) {
  this.clientesDao = clientesDao;
 }

 public void escribirDatosCliente(String id) {
  clientesDao.leerClienteDao(id);
 }
}
```


Cabe destacar que usamos la anotación Inject.

### IClienteCAo.java
```java
package es.jpascu.ioc.googleguice.services;

public interface IClienteDao {

 public void leerClienteDao(String id);
}
```

### ClienteDaoJdbc.java

```java
package es.jpascu.ioc.googleguice.services;

public class ClienteDaoJdbc implements IClienteDao {

 @Override
 public void leerClienteDao(String id) {
  System.out.println("Datos de cliente: " + id);
 }

}
```


Ahora para finalizar, desde la clase donde queramos utilizar LectorDatosClientes debemos incluir la lógica para crear dicha clase y sus dependencias mediante 
`com.google.inject.Injector`.


### TestGoogleGuice.java
```java
package es.jpascu.ioc.test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import es.jpascu.ioc.googleguice.services.ClienteDaoJdbc;
import es.jpascu.ioc.googleguice.services.IClienteDao;
import es.jpascu.ioc.googleguice.services.LectorDatosClientes;

public class TestGoogleGuice {
 public static void main(String args[]) {
  Injector injector = Guice.createInjector(new JdbcInjectionModule());
  LectorDatosClientes lectorClientes = injector
    .getInstance(LectorDatosClientes.class);

  lectorClientes.escribirDatosCliente("jpascu");
 }

 public static class JdbcInjectionModule extends AbstractModule {
  @Override
  protected void configure() {
   bind(IClienteDao.class).to(ClienteDaoJdbc.class);
  }

 }
}
```


Ahora tenemos una clase interna que es una subclasde de la AbstractModule, encargada del _binding_ de una interfaz con una implementación concreta. Para ello se debe
implementar el método configure.


Una vez qye hemos creado nuestro JdbcInjectionModule lo pasaremos como parámetro al objeto de la clase `com.google.inject.Guice.Injector`. A través de este objeto 
obtendremos una instancia singleton de nuestro LectorDatosClientes con la dependencia correctamente asociada.


#### Referencia
[Ejemplo de inyección de dependencias. Spring y Google Guice.](http://jpascu.blogspot.com/2013/02/inyeccion-de-dependencias-spring-y.html)
