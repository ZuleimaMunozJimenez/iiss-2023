package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface LoanService {
    void loanBook(String title, String borrower);
    void returnBook(String title);
    List<Book> getLoanedBooks();
    boolean isBookLoaned(String title);
}
