# Delegación en Python

En la realización de un ejemplo de delegación he hecho una clase _Libro_ y una clase _Biblioteca_. La clase _Libro_ tiene las propiedades de este que son `titulo`, `autor`, `anio_publicacion` y `num_paginas`. En cambio la clase _Biblioteca_ contiene una lista de libros y varios métodos para trabajar con ellos. Con esto hacemos uso de la delegación, evitando agregar todos los métodos de la clase _Libro_ dentro de _Biblioteca_.


La clase _Biblioteca_ contiene los métodos **agregar_libro** que realiza dicha funcionalidad recibiendo una instancia de libro como parámetro. Además contiene el método **mostrar_libros** que es un bucle que recorre la lista y muestra la información de cada libro utilizando los métodos **obtener_titulo**, **obtener_autor**, **obtener_anio_publicacion** y **obtener_num_paginas** de la clase _Libro_.


## Implementación


### Clase Libro

```py
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
```


### Clase Biblioteca
```py
class Biblioteca:
    def __init__(self):
        self.libros = []

    def agregar_libro(self, libro):
        self.libros.append(libro)

    def mostrar_libros(self):
        for libro in self.libros:
            print(f"{libro.obtener_titulo()} - {libro.obtener_autor()} - {libro.obtener_anio_publicacion()} - {libro.obtener_num_paginas()}\n")
```


### Código de ejemplo de funcionamiento.

```py
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
```

El resultado de ejecutar este código de prueba es el que se muestra en la imagen.


![Resultado de la ejecución del ejemplo](imagen.png "Resultado")
