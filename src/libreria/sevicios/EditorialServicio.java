package libreria.sevicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {

    private final EditorialDAO daoEditorial;
    private final Scanner sc;

    public EditorialServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.daoEditorial = new EditorialDAO();

    }

    public void crearEditorial(String nombre, boolean estado) throws Exception {
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar nombre");
                //Creamos el editorial
            }
            Editorial a = new Editorial();
            a.setNombre(nombre);
            a.setAlta(estado);

            //Dejo independiente el SET de cargar mascotas, no obligo q cuando se log cargue su mascota
            daoEditorial.guardarEditorial(a);
        } catch (Exception e) {
            System.out.println("No se creeo el editorial" + e.getMessage());
        }
    }

    public void modificarNombreEditorial(String nombre) throws Exception {
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el editorial");
            }
            //Buscamos
            Editorial editorial = buscarEditorialPorNombre(nombre);
            System.out.println("Vamos a modificar la editorial");
            System.out.println("Nombre de editorial: " + editorial.getNombre() + " Por:");
            String nombreNuevo = sc.next();
            editorial.setNombre(nombreNuevo);
            daoEditorial.modificarEditorial(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEditorial(String nombre) throws Exception {
        try {

            daoEditorial.eliminarEditorialNombre(nombre);
            System.out.println("USUARIO ELIMINADO CON EXITO");
        } catch (Exception e) {
            throw e;
        }
    }

    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
        try {
            //Validamos
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre del editorial");
            }
            Editorial editorial = daoEditorial.buscarEditorialPorNombre(nombre);
            return editorial;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Editorial> listaEditorials() throws Exception {
        try {
            Collection<Editorial> editorials = daoEditorial.listarEditorials();
            return editorials;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirEditorials() throws Exception {
        try {
            //Listamos los editorials
            Collection<Editorial> editorials = listaEditorials();
            //Imprimimos los editorials - Solo algunos atributos....
            if (editorials.isEmpty()) {
                throw new Exception("No existen editorials para imprimir");
            } else {

                for (Editorial u : editorials) {
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

    public void imprimirUnEditorial(String nombre) throws Exception {
        System.out.println(daoEditorial.buscarEditorialPorNombre(nombre));
    }

}
