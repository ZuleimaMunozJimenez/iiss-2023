class Compra {
  def calcularPrecioTotal(libros: List[Libro], politicaDescuento: PoliticaDescuento): Double = {
    val descuento = politicaDescuento.calcularDescuento(libros)
    val precioTotal = libros.map(_.precio).sum
    precioTotal - (precioTotal * descuento)
  }
}
