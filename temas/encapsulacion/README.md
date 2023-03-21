# Encapsulación en Java
He realizado un ejemplo de encapsulación sencillo. Me he basado en la creación de una clase llamada Libro. La clase está formada por tres variables
y algunos métodos públicos.

En este caso he utilizado la encapsulación para mantener las variables de la clase privadas, quedando innacesibles fuera de la clase. De este modo,
el único acceso externo a las variables es a través de los métodos públicos que acceden e imprimen las variabes.

## Implementación

```
import java.util.*;

 public class Libro 
 {
  private String titulo;
  private String autor;
  private int numPaginas;
  public Libro(String titulo, String autor, int numPaginas) {
    this.titulo = titulo; // variable privada para el título del libro
    this.autor = autor; // variable privada para el autor del libro
    this.numPaginas = numPaginas; // variable privada para el número de páginas del libro
  }
    // métodos públicos para acceder a las variables privadas
    public String getTitulo() {
      return titulo;
    }
    
    public String getAutor() {
      return autor;
    }
    
    public int getNumPaginas() {
      return numPaginas;
    }
  
  // método público para imprimir la información del libro
  public void imprimirInfo() {
    System.out.println("El titulo es: " + getTitulo() + ".\n");
    System.out.println("El autor es: " + getAutor()+".\n");
    System.out.println("El numero de paginas es: " + getNumPaginas() + ".\n");
  }

}
```

La clase consta de 3 variables declaradas como privadas : `titulo`, `autor` y `numPaginas`. Las cuales almacenarán la información de un libro.
Además, la clase consta de un método constructor parametrizado, 3 métodos públicos con los que acceder a las variables de la clase y un método público que imprimirá por
pantalla el contenido de las variables de la clase.


Para demostrar su funcionamiento hacemos uso de las siguientes líneas de código:

```
public class Main {
    
public static void main(String[] args)
{
  Libro miLibro = new Libro("El gran Gatsby", "F. Scott Fitzgerald", 180);
  // intentando acceder a las variables privadas desde fuera de la clase (esto debería dar como resultado "undefined")
  System.out.println(miLibro.titulo); //undefined
  // llamando al método público "imprimirInfo" para mostrar la información del libro
  miLibro.imprimirInfo(); // "El gran Gatsby" de F. Scott Fitzgerald, 180 páginas
}
}
```

El siguiente código nos dirá que hay un error porque no puede acceder a titulo. Pero en cambio, si comentamos esa línea y ejecutamos lo demás, podemos ver el contenido
de la clase.
