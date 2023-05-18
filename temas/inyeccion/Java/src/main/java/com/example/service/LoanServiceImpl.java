package com.example.service;

import com.example.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanServiceImpl implements LoanService {
    private Map<String, String> loanedBooks;

    public LoanServiceImpl() {
        this.loanedBooks = new HashMap<>();
    }

    @Override
    public void loanBook(String title, String borrower) {
        loanedBooks.put(title, borrower);
    }

    @Override
    public void returnBook(String title) {
        loanedBooks.remove(title);
    }

    @Override
    public List<Book> getLoanedBooks() {
        List<Book> loanedBookList = new ArrayList<>();

        for (Map.Entry<String, String> entry : loanedBooks.entrySet()) {
            String title = entry.getKey();
            String borrower = entry.getValue();
            Book book = new Book(title, borrower);
            loanedBookList.add(book);
        }

        return loanedBookList;
    }

    @Override
    public boolean isBookLoaned(String title) {
        return loanedBooks.containsKey(title);
    }
}
