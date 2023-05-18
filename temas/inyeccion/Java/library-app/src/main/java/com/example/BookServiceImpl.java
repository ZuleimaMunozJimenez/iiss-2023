package com.example;

import com.google.inject.Inject;

public class BookServiceImpl implements BookService {
    private Library library;

    @Inject
    public BookServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public void addBook(String title, Author author) {
        Book book = new Book(title, author);
        library.addBook(book);
        System.out.println("Book added: " + book.getTitle() + " by " + author.getName());
    }
}
