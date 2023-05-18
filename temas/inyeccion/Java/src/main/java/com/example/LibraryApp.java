package com.example;

import com.example.service.BookService;
import com.example.service.LoanService;
import com.google.inject.Inject;

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
        bookService.addBook("El Gran Gatsby", "F. Scott Fitzgerald");
        bookService.addBook("Cien años de soledad", "Gabriel García Márquez");
        bookService.addBook("1984", "George Orwell");

        loanService.loanBook("El Gran Gatsby", "John Doe");
        loanService.loanBook("1984", "Jane Smith");

        System.out.println("Libros disponibles:");
        bookService.getAllBooks().forEach(System.out::println);

        System.out.println("Libros prestados:");
        loanService.getLoanedBooks().forEach(System.out::println);
    }
}
