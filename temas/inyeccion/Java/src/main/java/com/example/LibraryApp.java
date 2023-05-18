// Clase principal de la aplicación
public class LibraryApp {
    private final BookService bookService;
    private final LoanService loanService;

    @Inject
    public LibraryApp(BookService bookService, LoanService loanService) {
        this.bookService = bookService;
        this.loanService = loanService;
    }

    public void run() {
        // Lógica de la aplicación de la biblioteca
        // utilizando los servicios inyectados
    }
}
