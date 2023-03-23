# Encapsulación en Scala
He realizado un ejemplo de encapsulación sencillo. Me he basado en la creación de una clase llamada Libro. La clase está formada por tres variables privadas declaradas haciendo uso de `private` y `var`.

En este caso he utilizado la encapsulación para mantener las variables y uno de los métodos de la clase privados, quedando innacesibles fuera de la clase. De este modo,
el único acceso externo a las variables es a través de los métodos públicos que acceden e imprimen las variables. Y el único acceso externo al método es a traés de otro método público que lo use.

## Implementación

```scala
class Libro(private var _titulo: String, private var _autor: String, private var _editorial: String) {

  def titulo: String = _titulo
  def autor: String = _autor
  def editorial: String = _editorial

  def titulo_=(nuevoTitulo: String): Unit = {
    _titulo = nuevoTitulo
  }

  def autor_=(nuevoAutor: String): Unit = {
    _autor = nuevoAutor
  }

  def editorial_=(nuevaEditorial: String): Unit = {
    _editorial = nuevaEditorial
  }

  override def toString: String = s"$titulo, $autor, $editorial"
}
```

La clase consta de 4 variables declaradas como privadas : `titulo`, `autor`, `precio` y `valoracion`. Las cuales almacenarán la información de un libro.
Además, la clase consta de seis métodos públicos con los que acceder a las variables de la clase, cuatro de ellos para leer y dos de ellos para modificar, y para finalizar un método privado.


Para demostrar su funcionamiento hacemos uso de las siguientes líneas de código (contenido en el archivo Libro.py):

```scala
object Main extends App {

  val libro = new Libro("Antes de diciembre", "Autor desconocido", "Planeta")
  println(libro) // La Odisea, Homero, Gredos

  libro.autor = "Joana Marcús"
  libro.editorial = "Penguin House"
  println(libro) // La Odisea, Autor desconocido, Anaya
}

```

El siguiente código nos dirá que la información del libro, además modifica el precio y lo muestra modificado. También nos muestra la valoración y la valoración después de ser modificada. Igualmente para demostrar que las variables y el método son inaccesibles fuera de la clase, hay dos errores en forma de comentario que si fuesen líneas ejecutables nos informarían que no puede accederse a dicha variable ni a dicho método.
