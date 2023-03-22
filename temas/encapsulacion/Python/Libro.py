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

# Crear un objeto de libro
libro1 = Libro("Antes de Diciembre", "Joana Marcús", 20)

# Obtener el título y el autor del libro (uso de método get)
print("Título del libro:", libro1.get_titulo())
print("Autor del libro:", libro1.get_autor())

# Actualizar el precio del libro (uso de método set)
libro1.set_precio(25)

# Obtener el nuevo precio del libro (uso de método get)
print("Precio del libro:", libro1.get_precio())
