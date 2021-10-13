
package libreria.sevicios;

import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import libreria.entidades.Author;
import libreria.entidades.Book;
import libreria.entidades.Editorial;
import libreria.persistencia.BookDAO;

public class BookServicio {
    
    
    private final AuthorServicio autorService;
    private final EditorialServicio editorialServicio;
    private final BookDAO daoBook;
    private Scanner sc;
    public BookServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n");       
        this.autorService = new AuthorServicio();
        this.editorialServicio=new EditorialServicio();
        this.daoBook=new BookDAO();
    }
    
    public Collection<Author> listAuthor() throws Exception{
          Collection<Author> autores = autorService.listaAuthors();       
       
          return autores;
     } 
    public Author buscarAuthor(String nombre) throws Exception{
        Collection<Author> autores=listAuthor();
        for (Author autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombre)) {
                return autor;
            }
        }
        return null;
        }       
 
     public Collection<Editorial> listEditorial() throws Exception{
          Collection<Editorial> editoriales = editorialServicio.listaEditorials();         
         return editoriales;
     } 
      public Editorial buscarEditorial(String nombre) throws Exception{
        Collection<Editorial> editoriales=listEditorial();
        for (Editorial editorial : editoriales) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                return editorial;
            }
        }
        return null;
        }   

    public void crearLibro(String titulo, Integer anio, Integer cantLibros, Integer libroPres, boolean alta, Author autor,Editorial editorial) {
        try {
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar Tirulo libro");                        
            }if (anio==0||anio==null) {
                throw new Exception("Debe indicar el año del libro");
            }if (cantLibros==null||libroPres==null) {
                throw new Exception("Cantidad de ejemplares no puede ser nulo");
            }if (autor==null) {
                throw new Exception("Error al cargar Autor");
            }if (editorial==null) {
                throw new Exception("Error al cargar Editorial");
            }   
            Integer restoEjemplares=cantLibros-libroPres;
            Book b=new Book();
            b.setIsbn(UUID.randomUUID().toString());
            b.setTitulo(titulo);
            b.setAnio(anio);
            b.setEjemplares(cantLibros);
            b.setEjemplaresPrestaos(libroPres);
            b.setAlta(alta);
            b.setAuthor(autor);
            b.setEditorial(editorial);
            b.setEjemplaresRestantes(restoEjemplares);
           
            //Dejo independiente el SET de cargar mascotas, no obligo q cuando se log cargue su mascota
             daoBook.guardarBook(b);
        } catch (Exception e) {
            System.out.println("No se creeo el Libro"+ e.getMessage());
        }
    
    
    }
    
     public Collection<Book> listaBooks() throws Exception {
        try {
            Collection<Book> books = daoBook.listarBooks();
            return books;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirBooks() throws Exception {
        try {
            //Listamos los autors
            Collection<Book> books = listaBooks();      
            //Imprimimos los autors - Solo algunos atributos....
            if (books.isEmpty()) {
                throw new Exception("No existen Libros para imprimir");
            } else {
                
                for (Book u : books) {
                    System.out.println("*****************************************");
                    System.out.println(" ID: " + u.getIsbn());
                    System.out.println(" Nombre: " + u.getTitulo());
                    System.out.println(" Ejemplares: " + u.getEjemplares());
                    System.out.println(" E. Prestados: " + u.getEjemplaresPrestaos());
                    System.out.println(" E. Restantes: " + u.getEjemplaresRestantes());
                    System.out.println(" Autor: " + u.getAuthor().getNombre());
                    System.out.println(" Editorial: " + u.getEditorial().getNombre());           
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
    public void modificarNombreBook(String nombre) throws Exception {
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un titulo del libro");
            }           
            //Buscamos
            Book book = buscarBookPorNombre(nombre);
             System.out.println("Vamos a modificar Titulo del libro");
             System.out.println("Nombre de Titulo: "+book.getTitulo()+" Por:");
             String nombreNuevo=sc.next();
             book.setTitulo(nombreNuevo);
             daoBook.modificarBook(book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public Book buscarBookPorNombre(String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null) {
                throw new Exception("Debe indicar el titulo del libro");
            }
            Book book = daoBook.buscarBookPorNombre(nombre);
            return book;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarBook(String nombre) throws Exception {
        try {            
            daoBook.eliminarBookNombre(nombre);
            System.out.println("LIBRO ELIMINADO CON EXITO");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
