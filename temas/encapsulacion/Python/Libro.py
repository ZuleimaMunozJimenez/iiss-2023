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
