// Clase principal de la aplicación
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new LibraryModule());
        LibraryApp app = injector.getInstance(LibraryApp.class);
        app.run();
    }
}
