# Herencia en Python
He realizado un ejemplo de herencia sencillo basado en el ejemplo del tema anterior. Me he basado en la creación de una superclase llamada Libros y una subclase Novela.

La clase `Libro` tiene un método constructor que acepta tres parámetros: `titulo`,`autor` y `numPaginas`. Además. tiene un método que muestra la información del libro.
La subclase `Novela` hereda de la clase `Libro` añadiendo esta en la declaración de la subclase entre paréntesis. Esta clase tiene un constructor que acepta los mismos parámetros que la clase padre,
 además de un parámetro adicional que en este caso es el género del libro. Además también tiene un método para mostrar la información completa.


## Implementación


### Superclase

```py
class Libro:
    def __init__(self, titulo, autor, numPaginas):
        self.titulo = titulo
        self.autor = autor
        self.numPaginas = numPaginas

    def imprimir(self):
        print(f"El título es: {self.titulo}\nEscrito por: {self.autor}\nCuenta con un total de {self.numPaginas} páginas\n")
```


### Subclase
```py
class Novela(Libro):
    def __init__(self, titulo, autor, numPaginas, genero):
        super().__init__(titulo, autor, numPaginas)
        self.genero = genero

    def imprimir(self):
        print(f"El título es: {self.titulo}\nEscrito por: {self.autor}\nCuenta con un total de {self.numPaginas} páginas\nSu género es {self.genero}\n")
```


### Código de ejemplo de funcionamiento.

```py
# Ejemplo de uso
miNovela = Novela("Antes de Diciembre", "Joana Marcús", 493, "Romántico juvenil")
miNovela2 = Novela("El mapa de los anhelos", "Alice Kellen", 496, "Romántica contemporánea")
miNovela.imprimir()
miNovela2.imprimir()
```
