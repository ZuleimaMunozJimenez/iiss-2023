# Herencia en Scala
He realizado un ejemplo de herencia sencillo basado en el ejemplo del tema anterior. Me he basado en la creación de una superclase llamada _Libros_ y dos subclase llamadas _LibroRomance_ y _LibroClasificado_.


La clase `Libro` tiene un método constructor que acepta dos parámetros: `titulo` y `autor`. Además, tiene un método llamado `leer`.


La subclase `LibroRomance` hereda de la clase `Libro`  haciendo uso de la función `extend`. Esta clase tiene un constructor que acepta los mismos parámetros que la clase padre,
 además de un parámetro adicional que en este caso es el género del libro. Además también tiene un método para mostrar la información del libro que se está leyendo, usando la sobreescritura del método `leer`.


La subclase `LibroClasificado` hereda de la clase `Libro`  haciendo uso de la función `extend`. Esta clase tiene un constructor que acepta los mismos parámetros que la clase padre,
 además de un parámetro adicional que en este caso es la clasificación por edad del libro. Además también tiene un método para mostrar la información del libro que se está leyendo, usando la sobreescritura del método `leer` igual que en la subclase anterior.
 

## Implementación


### Superclase Libro

```scala
abstract class Libro(val titulo: String, val autor: String) {
  def leer(): Unit
}
```


### Subclase LibroRomance
```scala
class LibroRomance(titulo: String, autor: String, val genero: String) extends Libro(titulo, autor) {
  override def leer(): Unit = {
    println(s"Leyendo $titulo de $autor del género $genero")
  }
}
```


### Subclase LibroClasificado
```scala
class LibroClasificado(titulo: String, autor: String, val edad: String) extends Libro(titulo, autor) {
  override def leer(): Unit = {
    println(s"Leyendo $titulo escrito por $autor con una clasificacion de edad $edad")
  }
}
```

### Código de ejemplo de funcionamiento.

```scala
object Main {
  def main(args: Array[String]): Unit = {
    val libro1 = new LibroRomance("El mapa de los anhelos", "Alice Kellen", "Romance contemporáneo")
    val libro2 = new LibroClasificado("El principito", "Antoine de Saint-Exupéry", " 6-7 años")
    
    libro1.leer() 
    libro2.leer() 
  }
}
```
