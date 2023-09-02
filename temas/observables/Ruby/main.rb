# main.rb

require_relative 'book_library'
require_relative 'observers'

# Crea una instancia de la biblioteca y registra observadores.
library = Library.new
catalog_observer = Catalog.new
notifications_observer = Notifications.new

library.add_observer(catalog_observer)
library.add_observer(notifications_observer)

# Agrega libros a la biblioteca.
book1 = Book.new("El Gran Gatsby", "F. Scott Fitzgerald")
book2 = Book.new("Cien años de soledad", "Gabriel García Márquez")

library.add_book(book1)
library.add_book(book2)
