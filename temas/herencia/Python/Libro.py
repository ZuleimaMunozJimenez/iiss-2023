class Libro:
    def __init__(self, titulo, autor, numPaginas):
        self.titulo = titulo
        self.autor = autor
        self.numPaginas = numPaginas

    def imprimir(self):
        print(f"El título es: {self.titulo}\nEscrito por: {self.autor}\nCuenta con un total de {self.numPaginas} páginas\n")

class Novela(Libro):
    def __init__(self, titulo, autor, numPaginas, genero):
        super().__init__(titulo, autor, numPaginas)
        self.genero = genero

    def imprimir(self):
        print(f"El título es: {self.titulo}\nEscrito por: {self.autor}\nCuenta con un total de {self.numPaginas} páginas\nSu género es {self.genero}\n")

# Ejemplo de uso
miNovela = Novela("Antes de Diciembre", "Joana Marcús", 493, "Romántico juvenil")
miNovela2 = Novela("El mapa de los anhelos", "Alice Kellen", 496, "Romántica contemporánea")
miNovela.imprimir()
miNovela2.imprimir()
