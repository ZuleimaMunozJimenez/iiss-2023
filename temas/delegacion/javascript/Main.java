public class Main {
    public static void main(String[] args)
    {
        Libreria milibreria = new Libreria();
        Libro libro1 = new Libro("Antes de Diciembre", "Joana Marcús", 17.95);
        Libro libro2 = new Libro("El mapa de los anhelos", "Alice Kellen", 8.75);
        Libro libro3 = new Libro("La chica invisible", "Blue Jeans", 19.99);
        milibreria.agregarLibro(libro1);
        milibreria.agregarLibro(libro2);
        milibreria.agregarLibro(libro3);

        milibreria.mostrarLibros();
        
        milibreria.eliminarLibro(libro2);
        milibreria.mostrarLibros();

    }
}
