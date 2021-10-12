
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Author;
import libreria.entidades.Book;

public class BookDAO {
        private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
       private final EntityManager em = emf.createEntityManager();
                
    public void guardarBook(Book book) throws Exception {
        em.getTransaction().begin();
        em.persist(book);       
        em.getTransaction().commit();
    }

    public void modificarBook(Book book) throws Exception {
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
    }

    public void eliminarBookId(String id) throws Exception {
        Book book = buscarBookPorId(id);
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

    public void eliminarBookNombre(String nombre) throws Exception {
        Book book = buscarBookPorNombre(nombre);
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

    public Book buscarBookPorId(String id) throws Exception {
        Book book = em.find(Book.class, id); // Esto que envio es la llave primaria
        return book;
    }
    //CONSULTA CON PARAMETROS


    //CONSULTA SIN PARAMETROS

    public List<Book> listarBooks() throws Exception {
        List<Book> books = em.createQuery("SELECT d FROM Book d")
                .getResultList();        
        return books;
    }

    public Book buscarBookPorNombre(String nombre) {
       
         Book book = (Book) em.createQuery("SELECT b "
                + " FROM Book b"
                + " WHERE b.titulo LIKE :nombre").
                setParameter("nombre", nombre).
                getSingleResult(); 
         return book;
    }

   
}
