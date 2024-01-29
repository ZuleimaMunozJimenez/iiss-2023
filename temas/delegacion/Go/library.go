package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

// Define una estructura base para un libro con información común.
type Book struct {
	Title  string
	Author string
}

// Define una interfaz para la funcionalidad común de un libro.
type BookOperations interface {
	GetDetails() string
}

// Define una estructura para libros físicos que delega en la estructura base Book.
type PhysicalBook struct {
	Book
	IsAvailable bool
}

// Implementa la interfaz BookOperations para libros físicos.
func (pb PhysicalBook) GetDetails() string {
	availability := "disponible"
	if !pb.IsAvailable {
		availability = "no disponible"
	}
	return fmt.Sprintf("%s by %s (%s)", pb.Title, pb.Author, availability)
}

// Define una estructura para libros electrónicos que también delega en la estructura base Book.
type EBook struct {
	Book
	Format string
}

// Implementa la interfaz BookOperations para libros electrónicos.
func (eb EBook) GetDetails() string {
	return fmt.Sprintf("%s by %s (Formato: %s)", eb.Title, eb.Author, eb.Format)
}

// Función para registrar un libro y mostrar sus detalles.
func RegisterAndDisplayDetails(book BookOperations) {
	fmt.Println("Registrando libro:")
	fmt.Println(book.GetDetails())
}

func main() {
	var books []BookOperations

	// Loop interactivo para que el usuario ingrese detalles de los libros
	for {
		fmt.Println("Ingrese los detalles de un libro (Titulo, autor y formato (si es Ebook)) separando con una coma cada campo o escriba 'fin' para finalizar:")

		// Leer entrada del usuario
		scanner := bufio.NewScanner(os.Stdin)
		scanner.Scan()
		input := scanner.Text()

		// Verificar si el usuario quiere salir del programa
		if strings.ToLower(input) == "fin" {
			break
		}

		// Dividir la entrada en título, autor y formato (si es un libro electrónico)
		bookDetails := strings.Split(input, ",")

		// Verificar si la entrada es válida
		if len(bookDetails) < 2 {
			fmt.Println("Entrada no válida. Debe ingresar al menos título y autor.")
			continue
		}

		// Crear un libro físico por defecto
		var newBook BookOperations = PhysicalBook{
			Book: Book{
				Title:  bookDetails[0],
				Author: bookDetails[1],
			},
			IsAvailable: true,
		}

		// Verificar si se proporcionó el formato para un libro electrónico
		if len(bookDetails) > 2 {
			newBook = EBook{
				Book: Book{
					Title:  bookDetails[0],
					Author: bookDetails[1],
				},
				Format: bookDetails[2],
			}
		}

		// Agregar el libro a la lista
		books = append(books, newBook)
	}

	// Registrar y mostrar detalles de los libros
	fmt.Println("\nDetalles de los libros registrados:")
	for _, book := range books {
		RegisterAndDisplayDetails(book)
	}
}
