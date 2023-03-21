public class Libros {
    private String titulo;
    private String autor;
    private int numPaginas;
    public Libros(String titulo, String autor, int numPaginas) {
      this.titulo = titulo; // variable privada para el título del libro
      this.autor = autor; // variable privada para el autor del libro
      this.numPaginas = numPaginas; // variable privada para el número de páginas del libro
    }
    public String getTitulo() {
        return titulo;
      }
      
      public String getAutor() {
        return autor;
      }
      
      public int getNumPaginas() {
        return numPaginas;
      }
    
    // método público para imprimir la información del libro
    public void imprimirInfo() {
      System.out.println("El titulo es: " + getTitulo() + ".\n");
      System.out.println("El autor es: " + getAutor()+".\n");
      System.out.println("El numero de paginas es: " + getNumPaginas() + ".\n");
    }

}
