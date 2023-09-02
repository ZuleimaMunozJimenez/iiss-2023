# main.rb

require 'aspector'
require_relative 'biblioteca_aspecto'
require_relative 'biblioteca'

# Crear una instancia de Biblioteca
biblioteca = Biblioteca.new

# Aplicar el aspecto a la Biblioteca
BibliotecaAspecto.apply(biblioteca)

# Ejecutar algunas operaciones en la biblioteca
biblioteca.agregar_libro("Cien años de soledad")
biblioteca.prestar_libro("Harry Potter y la piedra filosofal")
