public class main {
    
public static void main(String[] args)
{
  Libro miLibro = new Libro("El gran Gatsby", "F. Scott Fitzgerald", 180);
  // intentando acceder a las variables privadas desde fuera de la clase (esto debería dar como resultado "undefined")
  System.out.println(miLibro.titulo); //undefined
  // llamando al método público "imprimirInfo" para mostrar la información del libro
  miLibro.imprimirInfo(); // "El gran Gatsby" de F. Scott Fitzgerald, 180 páginas
}
}
