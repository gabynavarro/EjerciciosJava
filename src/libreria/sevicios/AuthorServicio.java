
package libreria.sevicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Author;
import libreria.persistencia.AuthorDAO;


public class AuthorServicio {
   // RECORDAR QUE SIEMPRE, LA LOGICA DEBE ESTAR EN EL SERVICIO CORRESPONDIENTE
    private final AuthorDAO daoAuthor;
     private final Scanner sc;
    public AuthorServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n"); 
        this.daoAuthor = new AuthorDAO();
       
    }

    public void crearAuthor(String nombre, boolean estado) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar nombre Autor");    
            //Creamos el autor
            }
           Author a = new Author();
            a.setNombre(nombre);
            a.setAlta(estado);  

            //Dejo independiente el SET de cargar mascotas, no obligo q cuando se log cargue su mascota
            
            daoAuthor.guardarAuthor(a);
        } catch (Exception e) {
            System.out.println("No se creeo el autor"+ e.getMessage());
        }
    }

    public void modificarNombreAuthor(String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el autor");
            }           
            //Buscamos
            Author autor = buscarAuthorPorNombre(nombre);
             System.out.println("Vamos a modificar el autor");
             System.out.println("Nombre de autor: "+autor.getNombre()+" Por:");
             String nombreNuevo=sc.next();
             autor.setNombre(nombreNuevo);
             daoAuthor.modificarAuthor(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarAuthor(String nombre) throws Exception {

        try {
            
            daoAuthor.eliminarAuthorId(nombre);
            System.out.println("USUARIO ELIMINADO CON EXITO");
        } catch (Exception e) {
            throw e;
        }
    }

    public Author buscarAuthorPorId(int id) throws Exception {
        try {

//            //Validamos
//            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
//                throw new Exception("Debe indicar el correo electrónico");
//            }

            Author autor = daoAuthor.buscarAuthorPorId(id);
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }

    public Author buscarAuthorPorNombre(String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre del autor");
            }
            Author autor = daoAuthor.buscarAuthorPorNombre(nombre);
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Author> listaAuthors() throws Exception {

        try {
            Collection<Author> autors = daoAuthor.listarAuthors();
            return autors;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirAuthors() throws Exception {
        try {
            //Listamos los autors
            Collection<Author> autors = listaAuthors();      
            //Imprimimos los autors - Solo algunos atributos....
            if (autors.isEmpty()) {
                throw new Exception("No existen autors para imprimir");
            } else {
                
                for (Author u : autors) {
                    System.out.println("*****************************************");
                    System.out.println(" ID: " + u.getId());
                    System.out.println(" Nombre: " + u.getNombre());
                   // System.out.println(" Estado: " + u.getAlta());                    
                   
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void imprimirUnAuthor(String nombre) throws Exception {
        System.out.println(daoAuthor.buscarAuthorPorNombre(nombre));
    }

 
  

  
}
