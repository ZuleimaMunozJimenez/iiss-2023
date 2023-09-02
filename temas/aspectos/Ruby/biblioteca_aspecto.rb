# biblioteca_aspecto.rb

require 'aspector'

class BibliotecaAspecto < Aspector::Base
  around :agregar_libro, method_arg: true do |method, proxy, *args, &block|
    libro = args[0]
    puts "Aspecto: Agregar libro '#{libro}' a la biblioteca."
    proxy.call(*args, &block)
    puts "Aspecto: Libro '#{libro}' agregado correctamente."
  end

  around :prestar_libro, method_arg: true do |method, proxy, *args, &block|
    libro = args[0]
    puts "Aspecto: Solicitada la operación de préstamo del libro '#{libro}'."
    proxy.call(*args, &block)
    puts "Aspecto: Libro '#{libro}' prestado con éxito."
  end
end
