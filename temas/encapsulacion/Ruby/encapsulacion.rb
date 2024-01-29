class Libro
    attr_reader :titulo, :autor, :anio
  
    def initialize(titulo, autor, anio)
      @titulo = titulo
      @autor = autor
      @anio = anio
    end
  
    def to_s
      "#{@titulo} por #{@autor}, #{@anio}"
    end
  end
  
  class Biblioteca
    def initialize
      @libros = []
    end
  
    def agregar_libro(libro)
      @libros << libro
      puts "Libro agregado: #{libro.titulo}"
    end
  
    def mostrar_libros
      if @libros.empty?
        puts "La biblioteca está vacía."
      else
        puts "Libros en la biblioteca:"
        @libros.each { |libro| puts libro }
      end
    end
  
    def buscar_libro_por_autor(autor)
      libros_encontrados = @libros.select { |libro| libro.autor == autor }
      if libros_encontrados.empty?
        puts "No se encontraron libros del autor #{autor}."
      else
        puts "Libros del autor #{autor}:"
        libros_encontrados.each { |libro| puts libro }
      end
    end
  end
  
  # Interacción con el usuario
  biblioteca = Biblioteca.new
  
  loop do
    puts "\nMenú:"
    puts "1. Agregar libro"
    puts "2. Mostrar libros"
    puts "3. Buscar libros por autor"
    puts "4. Salir"
  
    print "Ingrese su opción: "
    opcion = gets.chomp.to_i
  
    case opcion
    when 1
      print "Ingrese el título del libro: "
      titulo = gets.chomp
      print "Ingrese el autor del libro: "
      autor = gets.chomp
      print "Ingrese el año de publicación del libro: "
      anio = gets.chomp.to_i
  
      nuevo_libro = Libro.new(titulo, autor, anio)
      biblioteca.agregar_libro(nuevo_libro)
  
    when 2
      biblioteca.mostrar_libros
  
    when 3
      print "Ingrese el nombre del autor: "
      autor_busqueda = gets.chomp
      biblioteca.buscar_libro_por_autor(autor_busqueda)
  
    when 4
      puts "Saliendo del programa. ¡Hasta luego!"
      break
  
    else
      puts "Opción no válida. Por favor, ingrese una opción válida."
    end
  end
  