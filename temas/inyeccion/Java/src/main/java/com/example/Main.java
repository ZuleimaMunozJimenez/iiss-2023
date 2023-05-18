package com.example;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new LibraryModule());
        LibraryApp app = injector.getInstance(LibraryApp.class);
        app.run();
    }
}
