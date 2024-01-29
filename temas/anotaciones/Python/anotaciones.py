from dataclasses import dataclass
from typing import List

@dataclass
class Autor:
    nombre: str
    nacionalidad: str

@dataclass
class Libro:
    titulo: str
    autor: Autor
    anio_publicacion: int

def buscar_libros_por_autor(biblioteca: List[Libro], autor_a_buscar: str) -> List[Libro]:
    """
    Busca libros en la biblioteca por el nombre del autor.

    :param biblioteca: Lista de libros en la biblioteca.
    :type biblioteca: list[Libro]
    :param autor_a_buscar: Nombre del autor a buscar.
    :type autor_a_buscar: str
    :return: Lista de libros escritos por el autor buscado.
    :rtype: list[Libro]
    """
    libros_del_autor = [libro for libro in biblioteca if libro.autor.nombre == autor_a_buscar]
    return libros_del_autor

# Crear algunos autores y libros
autor1 = Autor(nombre="Gabriel García Márquez", nacionalidad="Colombiana")
autor2 = Autor(nombre="J.K. Rowling", nacionalidad="Británica")

libro1 = Libro(titulo="Cien años de soledad", autor=autor1, anio_publicacion=1967)
libro2 = Libro(titulo="Harry Potter y la piedra filosofal", autor=autor2, anio_publicacion=1997)
libro3 = Libro(titulo="El otoño del patriarca", autor=autor1, anio_publicacion=1975)

# Crear una biblioteca
biblioteca = [libro1, libro2, libro3]

# Buscar libros por autor
autor_buscado = "Gabriel García Márquez"
libros_del_autor = buscar_libros_por_autor(biblioteca, autor_buscado)

# Imprimir resultados
print(f"Libros escritos por {autor_buscado}:")
for libro in libros_del_autor:
    print(f"- {libro.titulo} ({libro.anio_publicacion})")
