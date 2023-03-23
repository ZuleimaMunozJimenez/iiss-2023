# Delegación en Scala

En la realización de un ejemplo de delegación he hecho una clase _Libro_ y una lista llena de
objetos de esta clase. La clase _Libro_ tiene las propiedades de este que son `titulo`, `autor`
y `paginas`. 


Teniendo esta lista de libros quiero ordenarlos de menor a mayot número de páginas. Para ello he
escrito una función que reciba la lista de libros y una función de comparación como argumentos,
y luego use la función de comparación para ordenar la lista.

## Implementación


### Clase Libro

```scala
case class Libro(titulo: String, autor: String, paginas: Int)

```


### Lista de libros
```scala
val libros = List(
  Libro("El señor de los anillos", "J.R.R. Tolkien", 1178),
  Libro("Antes de diciembre", "Joana Marcús", 493),
  Libro("Matar a un ruiseñor", "Harper Lee", 281),
  Libro("1984", "George Orwell", 328),
  Libro("Orgullo y prejuicio", "Jane Austen", 432)
)
```


### Función ordenar
```scala
def ordenarPor(libros: List[Libro], compare: (Libro, Libro) => Boolean): List[Libro] = {
  libros.sortWith(compare)
}
```

### Código de ejemplo de funcionamiento.

```scala
object Main {
  def main(args: Array[String]): Unit = {
val ordenarPorPaginas = (l1: Libro, l2: Libro) => l1.paginas < l2.paginas
val librosOrdenados = ordenarPor(libros, ordenarPorPaginas)

librosOrdenados.foreach(println)
  }
}
```


![Resultado de la ejecución del ejemplo](imagen.png "Resultado")
