# Encapsulación en Python
He realizado un ejemplo de encapsulación sencillo. Me he basado en la creación de una clase llamada Libro. La clase está formada por tres variables
y algunos métodos públicos junto con un método privado.

En este caso he utilizado la encapsulación para mantener las variables y uno de los métodos de la clase privados, quedando innacesibles fuera de la clase. De este modo,
el único acceso externo a las variables es a través de los métodos públicos que acceden e imprimen las variables. Y el único acceso externo al método es a traés de otro método público que lo use.

## Implementación

```py
class Libro:
    def __init__(self, titulo, autor, precio, valoracion):
        self.__titulo = titulo
        self.__autor = autor
        self.__precio = precio
        self.__valoracion = valoracion

    def get_titulo(self):
        return self.__titulo

    def get_autor(self):
        return self.__autor

    def get_precio(self):
        return self.__precio

    def set_precio(self, precio):
        self.__precio = precio

    def __modificar_valoracion(self, valoracion):
        self.__valoracion = valoracion
    def mostrar_valoracion(self):
        return self.__valoracion
    def aumentar_valoracion(self, libro):
        libro.__modificar_valoracion(5)
```

La clase consta de 4 variables declaradas como privadas : `titulo`, `autor`, `precio` y `valoracion`. Las cuales almacenarán la información de un libro.
Además, la clase consta de seis métodos públicos con los que acceder a las variables de la clase, cuatro de ellos para leer y dos de ellos para modificar, y para finalizar un método privado.


Para demostrar su funcionamiento hacemos uso de las siguientes líneas de código (contenido en el archivo Libro.py):

```py
# Crear un objeto de libro
libro1 = Libro("Antes de Diciembre", "Joana Marcús", 20, 4)

# Obtener el título del libro (uso de método get)
print("Título del libro:", libro1.get_titulo())
print("Autor del libro: ", libro1.get_autor())
# Intentar acceder directamente al atributo privado "__precio" causa un error
#print(libro1.__precio)

# Actualizar el precio del libro (uso de método set)
libro1.set_precio(25)

# Obtener el nuevo precio del libro (uso de método get)
print("Precio del libro:", libro1.get_precio())

print("Valoración:", libro1.mostrar_valoracion())

#Intentar acceder directamente al método privado "__modificar_valoracion" causa un error
#libro1.__modificar_valoracion(5)
libro1.aumentar_valoracion(libro1)
print("Valoración:", libro1.mostrar_valoracion())
```

El siguiente código nos dirá que la información del libro, además modifica el precio y lo muestra modificado. También nos muestra la valoración y la valoración después de ser modificada. Igualmente para demostrar que las variables y el método son inaccesibles fuera de la clase, hay dos errores en forma de comentario que si fuesen líneas ejecutables nos informarían que no puede accederse a dicha variable ni a dicho método.
