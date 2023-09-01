object EjemploDelegacionLibros {
  def main(args: Array[String]): Unit = {
    val libros = List(
      Libro("El principito", "Antoine de Saint-Exupéry", 15.0),
      Libro("Cien años de soledad", "Gabriel García Márquez", 20.0),
      Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 25.0),
      Libro("1984", "George Orwell", 18.0),
      Libro("El retrato de Dorian Gray", "Oscar Wilde", 12.0)
    )

    val compra = new Compra()

    val descuentoPorCantidad = new DescuentoPorCantidad()
    val descuentoPorPrecioTotal = new DescuentoPorPrecioTotal()

    val precioTotalConDescuento1 = compra.calcularPrecioTotal(libros, descuentoPorCantidad)
    val precioTotalConDescuento2 = compra.calcularPrecioTotal(libros, descuentoPorPrecioTotal)

    println(s"Precio total con descuento por cantidad: $$${precioTotalConDescuento1}")
    println(s"Precio total con descuento por precio total: $$${precioTotalConDescuento2}")
  }
}
