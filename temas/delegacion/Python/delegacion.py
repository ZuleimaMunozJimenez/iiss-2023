class Libro:
    def __init__(self, titulo, autor, anio_publicacion, num_paginas):
        self.titulo = titulo
        self.autor = autor
        self.anio_publicacion = anio_publicacion
        self.num_paginas = num_paginas

    def obtener_autor(self):
        return self.autor

    def obtener_titulo(self):
        return self.titulo

    def obtener_anio_publicacion(self):
        return self.anio_publicacion

    def obtener_num_paginas(self):
        return self.num_paginas


class Biblioteca:
    def __init__(self):
        self.libros = []

    def agregar_libro(self, libro):
        self.libros.append(libro)

    def mostrar_libros(self):
        for libro in self.libros:
            print(f"{libro.obtener_titulo()} - {libro.obtener_autor()} - {libro.obtener_anio_publicacion()} - {libro.obtener_num_paginas()}\n")

# Crear algunos libros
libro1 = Libro("Antes de diciembre", "Joana Marcús", 2021, 493)
libro2 = Libro("Orgullo y prejuicio", "Jane Austen", 1813, 360)

# Crear una biblioteca
biblioteca = Biblioteca()

# Agregar los libros a la biblioteca
biblioteca.agregar_libro(libro1)
biblioteca.agregar_libro(libro2)

# Mostrar los libros de la biblioteca
biblioteca.mostrar_libros()
