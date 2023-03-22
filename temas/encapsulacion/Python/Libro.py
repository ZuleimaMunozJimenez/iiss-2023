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
