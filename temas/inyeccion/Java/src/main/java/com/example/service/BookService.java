// Interfaz para el servicio de libros
public interface BookService {
    void addBook(String title, String author);
    List<Book> getAllBooks();
}
