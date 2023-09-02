# observers.rb

class Catalog
    def update(library, book)
      puts "Se ha agregado un libro al catálogo: #{book.title} por #{book.author}"
    end
  end
  
  class Notifications
    def update(library, book)
      puts "Has recibido una notificación sobre un nuevo libro: #{book.title}"
    end
  end
  