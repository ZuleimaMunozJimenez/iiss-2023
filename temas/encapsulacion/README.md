# Encapsulación en Python
He realizado un ejemplo de encapsulación sencillo. Me he basado en la creación de una clase llamada Libro. La clase está formada por tres variables
y algunos métodos públicos.

En este caso he utilizado la encapsulación para mantener las variables de la clase privadas, quedando innacesibles fuera de la clase. De este modo,
el único acceso externo a las variables es a través de los métodos públicos que acceden e imprimen las variabes.

## Implementación

```py
class Libro:
    def __init__(self, titulo, autor, precio):
        self.__titulo = titulo
        self.__autor = autor
        self.__precio = precio

    def get_titulo(self):
        return self.__titulo

    def get_autor(self):
        return self.__autor

    def get_precio(self):
        return self.__precio

    def set_precio(self, precio):
        self.__precio = precio
```

La clase consta de 3 variables declaradas como privadas : `titulo`, `autor` y `precio`. Las cuales almacenarán la información de un libro.
Además, la clase consta de cuatro métodos públicos con los que acceder a las variables de la clase, tres de ellos para leer y uno de ellos para modificar.


Para demostrar su funcionamiento hacemos uso de las siguientes líneas de código (contenido en el archivo Libro.py:

```py
# Crear un objeto de libro
libro1 = Libro("Antes de Diciembre", "Joana Marcús", 20)

# Obtener el título y el autor del libro (uso de método get)
print("Título del libro:", libro1.get_titulo())
print("Autor del libro:", libro1.get_autor())

# Intentar acceder directamente al atributo privado "__precio" causa un error
#print(libro1.__precio)

# Actualizar el precio del libro (uso de método set)
libro1.set_precio(25)

# Obtener el nuevo precio del libro (uso de método get)
print("Precio del libro:", libro1.get_precio())
```

El siguiente código nos dirá que la información del libro, además modifica el precio y lo muestra modificado. Igualmente para demostrar que las variables son inaccesibles fuera de la clase, hay un error en forma de comentario que si fuese una línea ejecutable nos informaría de que no puede acceder a dicha variable.
