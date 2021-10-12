package libreria.menu;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Author;
import libreria.sevicios.AuthorServicio;

public class MenuAuthor {
/*Recordar que este menu es a modo de orden para ir probando los metodos, no tiene importancia
    en si, ya que muy pronto los datos seran recibidos desde los formularios de las paginas web*/
    private final Scanner sc;
    private final AuthorServicio autorServicio;   

    public MenuAuthor() {
        this.sc = new Scanner(System.in);    
        this.autorServicio = new AuthorServicio();
    }

    public void menu() throws Exception {
     
            System.out.println("** MENU AUTOR: ***");
            System.out.println("==================");
            System.out.println(" 1- Crear");//OK
            System.out.println(" 2- Modificar");//OK
            System.out.println(" 3- Borrar");//OK
            System.out.println(" 4- Listar");//OK
            System.out.println(" 0- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    autorServicio.crearAuthor(nombreAutor(),estadoAlta());
                    break;
                case 2:
                     autorServicio.modificarNombreAuthor(buscarAuthor());                    
                    break;
                case 3:
                    autorServicio.eliminarAuthor(buscarAuthor());
                    break;  
                 case 4:
                    autorServicio.imprimirAuthors();
                    break;   
                case 0:
             //       System.exit(0);
                    break;
            }
   
       

    }

    private String nombreAutor() throws Exception{
        
        boolean validar=false;
        String nombre;
        do {            
            System.out.println("Nombre Autor: ");
            nombre=sc.next().toLowerCase();
            validar=validarAuthor(nombre);            
        } while (validar);        
        
        return nombre;
    }
   private boolean estadoAlta(){    
       
       return true;
   }

    public boolean validarAuthor(String nombre) throws Exception {
        boolean validar = false;
        try {
            Collection<Author> autores = autorServicio.listaAuthors();
            for (Author u : autores) {
                if (u.getNombre().equalsIgnoreCase(nombre)) {                
                    System.out.println("El nombre del Author exite!");
                    validar=true;
                   // throw new Exception("El autor ya existe, ingrese otro autor");
                   
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
      
        return validar;
    }


//    public Author encontrarAuthor() throws Exception {
//        System.out.println("Ingrese el ID del usuario");
//        String idAuthor = sc.next();
//        Author usuario = autorServicio.buscarAuthorPorId(idAuthor);
//        return usuario;
//    }

    public String buscarAuthor() {
        System.out.println("Ingrese el Autor ");
        String nombre = sc.next();        
        return nombre;
    }

    public String ingresarIdAuthor() {
        System.out.println("Ingrese el ID del autor");
        String idAuthor = sc.next();
        return idAuthor;
    }

 
}
