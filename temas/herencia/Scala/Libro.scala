abstract class Libro(val titulo: String, val autor: String) {
  def leer(): Unit
}

class LibroRomance(titulo: String, autor: String, val genero: String) extends Libro(titulo, autor) {
  override def leer(): Unit = {
    println(s"Leyendo $titulo de $autor del género $genero")
  }
}

class LibroClasificado(titulo: String, autor: String, val edad: String) extends Libro(titulo, autor) {
  override def leer(): Unit = {
    println(s"Leyendo $titulo escrito por $autor con una clasificacion de edad $edad")
  }
}

//Ejemplo de uso

object Main {
  def main(args: Array[String]): Unit = {
    val libro1 = new LibroRomance("El mapa de los anhelos", "Alice Kellen", "Romance contemporáneo")
    val libro2 = new LibroClasificado("El principito", "Antoine de Saint-Exupéry", " 6-7 años")
    
    libro1.leer() 
    libro2.leer() 
  }
}
