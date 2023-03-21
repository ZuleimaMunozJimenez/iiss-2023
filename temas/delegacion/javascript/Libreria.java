import java.util.*;
public class Libreria {
    public Libreria () {};
    private List<Libro> libros = new ArrayList<Libro>();
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }
    
    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println("--------------\n"+"Título: " + libro.getTitulo() + " \nAutor: " + libro.getAutor() + " \nPrecio: " + libro.getPrecio() + "\n--------------");
        }
    }
}
