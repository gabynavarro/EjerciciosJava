
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;
// comodin de busqueda
//em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE CONCAT('%', :nombre, '%')",
//Autor.class).setParameter("nombre", nombre).getResultList(); 

public class EditorialDAO {
       private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
       private final EntityManager em = emf.createEntityManager();
                
    public void guardarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.persist(editorial);       
        em.getTransaction().commit();
    }

    public void modificarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorialId(String id) throws Exception {
        Editorial editorial = buscarEditorialPorId(id);
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorialNombre(String nombre) throws Exception {
        Editorial editorial = buscarEditorialPorNombre(nombre);
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarEditorialPorId(String id) throws Exception {
        Editorial editorial = em.find(Editorial.class, id); // Esto que envio es la llave primaria
        return editorial;
    }
    //CONSULTA CON PARAMETROS

    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
        Editorial editorial = (Editorial) em.createQuery("SELECT d "
                + " FROM Editorial d"
                + " WHERE d.nombre LIKE :nombre").
                setParameter("nombre", nombre).
                getSingleResult();      
        return editorial;
    }
    //CONSULTA SIN PARAMETROS

    public List<Editorial> listarEditorials() throws Exception {
        List<Editorial> editorials = em.createQuery("SELECT d FROM Editorial d")
                .getResultList();        
        return editorials;
    }
}
