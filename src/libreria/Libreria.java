
package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.menu.MenuOpciones;


public class Libreria {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
        EntityManager em = emf.createEntityManager();
        MenuOpciones menuPrincipal=new MenuOpciones();
        menuPrincipal.menu();
    }
    
}
