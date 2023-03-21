public class LibroDeRomance extends Libros{
    private String genero;
    LibroDeRomance(String titulo, String autor, int numPaginas, String genero)
    {
        super(titulo, autor, numPaginas);
        this.genero=genero;
    }
    public void imprimirInfos()
    {
        imprimirInfo();
        System.out.println("El género es: " + genero + ".\n");
    }
}
