# Herencia en Java
He realizado un ejemplo de herencia sencillo basado en el ejemplo del tema anterior. Me he basado en la creación de una superclase llamada Libros y una subclase LibroDeRomance.

La clase `Libro` tiene un método constructor que acepta los tres parámetros que contiene. Además. tiene un método que muestra la información del libro.
La subclase `LibroDeFiccion` hereda de la clase `Libro` usando la palabra clave `extends`. Esta clase tiene un constructor que acepta los mismos parámetros que la clase padre,
 además de un parámetro adicional que en este caso es el género del libro. Además este método usa el método de la superclase para mostrar la información del libro.


## Implementación


### Superclase

```js
public class Libros {
    private String titulo;
    private String autor;
    private int numPaginas;
    public Libros(String titulo, String autor, int numPaginas) {
      this.titulo = titulo; // variable privada para el título del libro
      this.autor = autor; // variable privada para el autor del libro
      this.numPaginas = numPaginas; // variable privada para el número de páginas del libro
    }
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


### Subclase
```js
public class LibroDeRomance extends Libros{
    private String genero;
    LibroDeRomance(String titulo, String autor, int numPaginas, String genero)
    {
        super(titulo, autor, numPaginas);
        this.genero=genero;
    }
    public void imprimirInfos()
    {
        imprimirInfo();
        System.out.println("El género es: " + genero + ".\n");
    }
}
```


### Código de ejemplo de funcionamiento.

```js
public class Main {
    public static void main(String[] args)
{
  LibroDeRomance miLibro = new LibroDeRomance("Antes de diciembre", "Joana Marcús", 496, "romance juvenil");
  miLibro.imprimirInfos();
}
}
```
