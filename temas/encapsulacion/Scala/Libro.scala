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
