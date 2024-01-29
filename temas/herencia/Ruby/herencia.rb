# Clase base Book
class Book
    attr_accessor :title, :author
  
    def initialize(title, author)
      @title = title
      @author = author
    end
  
    def display_info
      puts "Título: #{@title}"
      puts "Autor: #{@author}"
    end
  end
  
  # Subclase Fiction que hereda de Book
  class Fiction < Book
    attr_accessor :genre
  
    def initialize(title, author, genre)
      super(title, author)
      @genre = genre
    end
  
    def display_info
      super
      puts "Género: #{@genre}"
    end
  end
  
  # Subclase NonFiction que hereda de Book
  class NonFiction < Book
    attr_accessor :topic
  
    def initialize(title, author, topic)
      super(title, author)
      @topic = topic
    end
  
    def display_info
      super
      puts "Tema: #{@topic}"
    end
  end
  
  # Subclase Ebook que hereda de Fiction
  class Ebook < Fiction
    attr_accessor :format
  
    def initialize(title, author, genre, format)
      super(title, author, genre)
      @format = format
    end
  
    def display_info
      super
      puts "Formato: #{@format}"
    end
  end
  
  # Interacción con el usuario
  def agregar_libro
    puts "¿Qué tipo de libro deseas agregar? (Ficción / No ficción / Ebook)"
    tipo_libro = gets.chomp.downcase
  
    case tipo_libro
    when "ficción"
      puts "Ingresa el título:"
      title = gets.chomp
      puts "Ingresa el autor:"
      author = gets.chomp
      puts "Ingresa el género:"
      genre = gets.chomp
      Fiction.new(title, author, genre)
    when "no ficción"
      puts "Ingresa el título:"
      title = gets.chomp
      puts "Ingresa el autor:"
      author = gets.chomp
      puts "Ingresa el tema:"
      topic = gets.chomp
      NonFiction.new(title, author, topic)
    when "ebook"
      puts "Ingresa el título:"
      title = gets.chomp
      puts "Ingresa el autor:"
      author = gets.chomp
      puts "Ingresa el género:"
      genre = gets.chomp
      puts "Ingresa el formato:"
      format = gets.chomp
      Ebook.new(title, author, genre, format)
    else
      puts "Tipo de libro no válido."
    end
  end
  
  def mostrar_info(libro)
    libro.display_info
  end
  
  # Ejemplo de uso
  biblioteca = []
  
  while true
    puts "\n=== Menú ==="
    puts "1. Agregar libro"
    puts "2. Mostrar información de libros"
    puts "3. Salir"
    print "Selecciona una opción: "
  
    opcion = gets.chomp.to_i
  
    case opcion
    when 1
      libro = agregar_libro
      biblioteca << libro if libro
      puts "Libro agregado con éxito."
    when 2
      puts "\n=== Información de libros ==="
      biblioteca.each_with_index do |libro, index|
        puts "\nLibro ##{index + 1}"
        mostrar_info(libro)
      end
    when 3
      puts "¡Adiós!"
      break
    else
      puts "Opción no válida. Inténtalo de nuevo."
    end
  end
  