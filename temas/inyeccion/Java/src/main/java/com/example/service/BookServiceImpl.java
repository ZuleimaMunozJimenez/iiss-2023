package com.example.service;

import com.example.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private List<Book> books;

    public BookServiceImpl() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    @Override
    public void removeBook(String title) {
        Book bookToRemove = findBookByTitle(title);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
