package com.example;

import com.google.inject.AbstractModule;

public class LibraryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BookService.class).to(BookServiceImpl.class);
        bind(Library.class);
    }
}
