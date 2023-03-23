case class Libro(titulo: String, autor: String, paginas: Int)

val libros = List(
  Libro("El señor de los anillos", "J.R.R. Tolkien", 1178),
  Libro("Antes de diciembre", "Joana Marcús", 493),
  Libro("Matar a un ruiseñor", "Harper Lee", 281),
  Libro("1984", "George Orwell", 328),
  Libro("Orgullo y prejuicio", "Jane Austen", 432)
)

def ordenarPor(libros: List[Libro], compare: (Libro, Libro) => Boolean): List[Libro] = {
  libros.sortWith(compare)
}


object Main {
  def main(args: Array[String]): Unit = {
val ordenarPorPaginas = (l1: Libro, l2: Libro) => l1.paginas < l2.paginas
val librosOrdenados = ordenarPor(libros, ordenarPorPaginas)

librosOrdenados.foreach(println)
  }
}
