package com.example;

import com.google.inject.Inject;

public class LibraryApp {
    private BookService bookService;

    @Inject
    public LibraryApp(BookService bookService) {
        this.bookService = bookService;
    }

    public void run() {
        Author author = new Author("John Doe");
        bookService.addBook("Sample Book", author);
    }
}
