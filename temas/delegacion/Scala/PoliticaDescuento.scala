abstract class PoliticaDescuento {
  def calcularDescuento(libros: List[Libro]): Double
}

class DescuentoPorCantidad extends PoliticaDescuento {
  override def calcularDescuento(libros: List[Libro]): Double = {
    val numLibros = libros.length
    if (numLibros >= 5) 0.2 else if (numLibros >= 3) 0.1 else 0.0
  }
}

class DescuentoPorPrecioTotal extends PoliticaDescuento {
  override def calcularDescuento(libros: List[Libro]): Double = {
    val precioTotal = libros.map(_.precio).sum
    if (precioTotal >= 100) 0.15 else if (precioTotal >= 50) 0.1 else 0.05
  }
}
