package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
)

// Notificador es una interfaz que define un método para enviar notificaciones.
type Notificador interface {
	EnviarNotificacion(mensaje string)
}

// AlmacenLibros es una interfaz que define métodos para almacenar y recuperar libros.
type AlmacenLibros interface {
	GuardarLibro(libro *Libro)
	ObtenerLibros() []*Libro
}

// Libro representa un libro con un título y un autor.
type Libro struct {
	Titulo string
	Autor  string
}

// ServicioNotificaciones es una estructura que encapsula la lógica de notificación.
type ServicioNotificaciones struct {
	Notificadores []Notificador
}

// NotificarNuevoLibro notifica a todos los notificadores cuando se ha añadido un nuevo libro.
func (sn *ServicioNotificaciones) NotificarNuevoLibro(libro *Libro) {
	mensaje := fmt.Sprintf("Nuevo libro agregado: '%s' de %s", libro.Titulo, libro.Autor)
	for _, notificador := range sn.Notificadores {
		notificador.EnviarNotificacion(mensaje)
	}
}

// ServicioAlmacenamiento es una estructura que encapsula la lógica de almacenamiento de libros.
type ServicioAlmacenamiento struct {
	Almacen AlmacenLibros
}

// AgregarLibro agrega un nuevo libro al almacenamiento.
func (sa *ServicioAlmacenamiento) AgregarLibro(libro *Libro) {
	sa.Almacen.GuardarLibro(libro)
}

// ServicioLibros es una estructura que coordina las operaciones relacionadas con libros.
type ServicioLibros struct {
	Almacenamiento ServicioAlmacenamiento
	Notificaciones ServicioNotificaciones
}

// AgregarLibro agrega un nuevo libro y notifica sobre la adición.
func (sl *ServicioLibros) AgregarLibro(libro *Libro) {
	sl.Almacenamiento.AgregarLibro(libro)
	sl.Notificaciones.NotificarNuevoLibro(libro)
}

// Implementación concreta de Notificador utilizando correo electrónico.
type CorreoElectronicoNotificador struct{}

// EnviarNotificacion implementa el método de la interfaz Notificador.
func (ce *CorreoElectronicoNotificador) EnviarNotificacion(mensaje string) {
	fmt.Println("Enviando notificación por correo electrónico:", mensaje)
}

// Implementación concreta de Notificador utilizando SMS.
type SMSNotificador struct{}

// EnviarNotificacion implementa el método de la interfaz Notificador.
func (sms *SMSNotificador) EnviarNotificacion(mensaje string) {
	fmt.Println("Enviando notificación por SMS:", mensaje)
}

// Implementación concreta de AlmacenLibros utilizando un slice en memoria.
type MemoriaAlmacenLibros struct {
	Libros []*Libro
}

// GuardarLibro implementa el método de la interfaz AlmacenLibros.
func (mal *MemoriaAlmacenLibros) GuardarLibro(libro *Libro) {
	mal.Libros = append(mal.Libros, libro)
}

// ObtenerLibros implementa el método de la interfaz AlmacenLibros.
func (mal *MemoriaAlmacenLibros) ObtenerLibros() []*Libro {
	return mal.Libros
}

func main() {
	// Configurar servicios con implementaciones concretas.
	var notificadores []Notificador
	notificadores = append(notificadores, &CorreoElectronicoNotificador{})
	notificadores = append(notificadores, &SMSNotificador{})

	servicioNotificaciones := ServicioNotificaciones{Notificadores: notificadores}
	almacenLibros := &MemoriaAlmacenLibros{}

	// Inyectar dependencias en los servicios.
	servicioAlmacenamiento := ServicioAlmacenamiento{Almacen: almacenLibros}
	servicioLibros := ServicioLibros{
		Almacenamiento: servicioAlmacenamiento,
		Notificaciones: servicioNotificaciones,
	}

	// Leer información del libro desde la entrada estándar de manera robusta.
	nuevoLibro, err := leerDatosLibro()
	if err != nil {
		log.Fatal("Error al leer los datos del libro:", err)
	}

	// Agregar un nuevo libro usando el servicio de libros.
	servicioLibros.AgregarLibro(nuevoLibro)

	// Obtener y mostrar todos los libros almacenados.
	librosAlmacenados := servicioAlmacenamiento.Almacen.ObtenerLibros()
	fmt.Println("Libros almacenados:")
	for _, libro := range librosAlmacenados {
		fmt.Printf("- %s de %s\n", libro.Titulo, libro.Autor)
	}
}

func leerDatosLibro() (*Libro, error) {
	scanner := bufio.NewScanner(os.Stdin)

	fmt.Print("Ingrese el título del libro: ")
	scanner.Scan()
	titulo := scanner.Text()

	fmt.Print("Ingrese el autor del libro: ")
	scanner.Scan()
	autor := scanner.Text()

	if err := scanner.Err(); err != nil {
		return nil, err
	}

	return &Libro{Titulo: titulo, Autor: autor}, nil
}
