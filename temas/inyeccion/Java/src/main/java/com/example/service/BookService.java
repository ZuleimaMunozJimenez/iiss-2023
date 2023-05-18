package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface BookService {
    void addBook(String title, String author);
    void removeBook(String title);
    List<Book> getAllBooks();
    Book findBookByTitle(String title);
}
