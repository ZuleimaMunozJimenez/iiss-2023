

// Implementación del servicio de libros
public class BookServiceImpl implements BookService {
    private List<Book> books;

    @Inject
    public BookServiceImpl() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
