object Main extends App {

  val libro = new Libro("Antes de diciembre", "Autor desconocido", "Planeta")
  println(libro) // Antes de diciembre, Autor desconocido, Planeta

  libro.autor = "Joana Marcús"
  libro.editorial = "Penguin House"
  println(libro) // Antes de diciembre, Joana Marcús, Penguin House
}
