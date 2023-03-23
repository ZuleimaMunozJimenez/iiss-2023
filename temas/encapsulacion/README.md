# Encapsulación en Scala
He realizado un ejemplo de encapsulación sencillo. Me he basado en la creación de una clase llamada Libro. La clase está formada por tres variables privadas declaradas haciendo uso de `private` y `var`.

En este caso he utilizado la encapsulación para mantener las variables de la clase privadas, quedando innacesibles fuera de la clase. De este modo,
el único acceso externo a las variables es a través de los métodos públicos declarados en la clase que acceden a ellas. 


Además he añadido una clase privada, que no puede ser usada de forma externa de la clase. Esta solo puede usarse a través de otro método que si es público. Para este ejemplo puede quedar un poco absurdo ese uso, pero solo queremos tener constancia de como puede hacerse en este ejemplo.

## Implementación

```scala
class Libro(private var _titulo: String, private var _autor: String, private var _editorial: String) {

  def titulo: String = _titulo
  def autor: String = _autor
  def editorial: String = _editorial

  private def titulo_=(nuevoTitulo: String): Unit = {
    _titulo = nuevoTitulo
  }

  def modtitulo_=(lib: Libro, tit: String): Unit = { lib.titulo = tit}

  def autor_=(nuevoAutor: String): Unit = {
    _autor = nuevoAutor
  }

  def editorial_=(nuevaEditorial: String): Unit = {
    _editorial = nuevaEditorial
  }

  override def toString: String = s"$titulo, $autor, $editorial"
}
```

La clase consta de 3 variables declaradas como privadas : `titulo`, `autor` y `editorial`. Las cuales almacenarán la información de un libro.
Además, la clase consta de siete métodos públicos con los que acceder a las variables de la clase, tres de ellos para leer una variable, tres de ellos para modificar y uno para imprimir el contenido del objeto de la clase. Y un metodo privado que modifica en este caso el título del libro. Esta es usada a través del método público `modtitulo`.


Para demostrar su funcionamiento hacemos uso de las siguientes líneas de código (contenido en el archivo Main.scala):

```scala
object Main extends App {

  val libro = new Libro("Antes de diciembre", "Autor desconocido", "Planeta")
  println(libro) // Antes de diciembre, Autor desconocido, Planeta
  //libro.titulo = "ADD"
  libro.modtitulo_=(libro, "ADD")
  libro.autor = "Joana Marcús"
  libro.editorial = "Penguin House"
  println(libro) // ADD, Joana Marcús, Penguin House
}
```

El siguiente código nos dirá la información del libro, además modifica el titulo, el autor y la editorial y lo muestra modificado.


Aparece en forma de comentario una línea que si formase parte del código nos diría que no puede acceder al método.
