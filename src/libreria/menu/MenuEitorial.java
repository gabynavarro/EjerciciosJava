package libreria.menu;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.sevicios.EditorialServicio;

public class MenuEitorial {

    private final Scanner sc;
    private final EditorialServicio editorialService;
    
    public MenuEitorial() {
        this.sc = new Scanner(System.in);        
        this.editorialService = new EditorialServicio();
    }
    
    public void menu() throws Exception {
        
        System.out.println("MENU EDITORIAL:");
        System.out.println("===============");
        System.out.println(" 1- Crear Editorial");//OK
        System.out.println(" 2- Modificar Editorial");//OK
        System.out.println(" 3- Borrar Editorial");//OK
        System.out.println(" 4- Listar Editoriales");//OK
        System.out.println(" 0- Salir");
        
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                editorialService.crearEditorial(cargarEditorial(), estadoAlta());
                break;
            case 2:
                editorialService.modificarNombreEditorial(buscarEditorial());                
                break;
            case 3:
                editorialService.eliminarEditorial(buscarEditorial());
                break;            
            case 4:
                editorialService.imprimirEditorials();
                break;            
            case 0:
                //  System.exit(0);
                break;
        }
        
    }
    
    private String cargarEditorial() throws Exception {
        
        boolean validar = false;
        String nombre;
        do {            
            System.out.println("Editorial del libro: ");
            nombre = sc.next().toLowerCase();
            validar = validarEditorial(nombre);    //validar si existe        
        } while (validar);        
        
        return nombre;
    }

    private boolean estadoAlta() {        
        return true;
    }
    
    public boolean validarEditorial(String nombre) throws Exception {
        boolean validar = false;
        try {
            Collection<Editorial> editoriales = editorialService.listaEditorials();
            for (Editorial u : editoriales) {
                if (u.getNombre().equalsIgnoreCase(nombre)) {                    
                    System.out.println("El nombre del Editorial exite!");
                    validar = true;
                    // throw new Exception("El editorial ya existe, ingrese otro editorial");
                    
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
        
        return validar;
    }

//    public Editorial encontrarEditorial() throws Exception {
//        System.out.println("Ingrese el ID del editorial");
//        String idEditorial = sc.next();
//        Editorial editorial = editorialServicio.buscarEditorialPorId(idEditorial);
//        return editorial;
//    }
    public String buscarEditorial() {
        System.out.println("Ingrese el Editorial ");
        String nombre = sc.next();        
        return nombre;
    }
    
    public String ingresarIdEditorial() {
        System.out.println("Ingrese el ID del editorial");
        String idEditorial = sc.next();
        return idEditorial;
    }
}
