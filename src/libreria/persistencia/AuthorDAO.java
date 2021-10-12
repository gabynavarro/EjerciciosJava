
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Author;

public class AuthorDAO {
     private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
    private final EntityManager em = emf.createEntityManager();
                
    public void guardarAuthor(Author autor) throws Exception {
        em.getTransaction().begin();
        em.persist(autor);       
        em.getTransaction().commit();
    }

    public void modificarAuthor(Author autor) throws Exception {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public void eliminarAuthorId(String nombre) throws Exception {
        Author autor = buscarAuthorPorNombre(nombre);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    public void eliminarAuthor(int id) throws Exception {
        Author autor = buscarAuthorPorId(id);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    public Author buscarAuthorPorId(int id) throws Exception {
        Author autor = em.find(Author.class, id); // Esto que envio es la llave primaria
        return autor;
    }
    //CONSULTA CON PARAMETROS

    public Author buscarAuthorPorNombre(String nombre) throws Exception {
        Author autor = (Author) em.createQuery("SELECT d "
                + " FROM Author d"
                + " WHERE d.nombre LIKE :nombre").
                setParameter("nombre", nombre).
                getSingleResult(); 
        return autor;
    }
    //CONSULTA SIN PARAMETROS

    public List<Author> listarAuthors() throws Exception {
        List<Author> autors = em.createQuery("SELECT d FROM Author d")
                .getResultList();        
        return autors;
    }
   // public Autor buscarAutorPorNombre1(String nombre, Boolean estado) throws MiExcepcion { try { Autor autor = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.alta = :estado", Autor.class) .setParameter("nombre", nombre) .setParameter("estado", estado) .getSingleResult(); return autor; } catch (NoResultException e) { return null; } catch (Exception e) { throw new MiExcepcion("ERROR AL BUSCAR AUTOR POR ID"); } } 

}
