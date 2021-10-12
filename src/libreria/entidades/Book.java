
package libreria.entidades;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import libreria.entidades.Author;
import libreria.entidades.Editorial;

@Entity// Esta anotacion, avisa que esta clase se convertira en TABLA
public class Book {
  
 //  @GeneratedValue    
   @Id
  private String isbn; 
  private String titulo;
  private Integer anio;
  private Integer ejemplares;
  private Integer ejemplaresPrestaos;
  private boolean alta;
  @OneToOne
  private Author author;
  @OneToOne
  private Editorial editorial;
  private Integer ejemplaresRestantes;

    public Book() {
    }

    public Book(String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestaos, boolean alta, Author author, Editorial editorial, Integer ejemplaresRestantes) {
     
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestaos = ejemplaresPrestaos;
        this.alta = alta;
        this.author = author;
        this.editorial = editorial;
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestaos() {
        return ejemplaresPrestaos;
    }

    public void setEjemplaresPrestaos(Integer ejemplaresPrestaos) {
        this.ejemplaresPrestaos = ejemplaresPrestaos;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

//    @Override
//    public String toString() {
//        return "Book{" + "isbn=" + isbn + ", titulo=" + titulo + ", anio=" + anio + ", ejemplares=" + ejemplares + ", ejemplaresPrestaos=" + ejemplaresPrestaos + ", alta=" + alta + ", author=" + author + ", editorial=" + editorial + ", ejemplaresRestantes=" + ejemplaresRestantes + '}';
//    }

   

  
    
}
