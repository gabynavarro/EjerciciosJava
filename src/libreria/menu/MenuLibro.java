package libreria.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Author;
import libreria.entidades.Editorial;

import libreria.sevicios.BookServicio;

public class MenuLibro {
/*Recordar que este menu es a modo de orden para ir probando los metodos, no tiene importancia
    en si, ya que muy pronto los datos seran recibidos desde los formularios de las paginas web*/
    private final Scanner sc;
    private final BookServicio bookService;
 
   

    public MenuLibro() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.bookService = new BookServicio();
   
    }

    public void menu() throws Exception {
     
     
            System.out.println("MENU LIBRO:");
            System.out.println("===============");

            System.out.println(" 1- Crear Libro");//OK
            System.out.println(" 2- Modificar Libro");//OK
            System.out.println(" 3- Borrar Libro");//OK
            System.out.println(" 4- Listar Libros");//OK            
            System.out.println(" 0- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                     bookService.crearLibro(cargarTituloLibro(),cargarAnioLibro(),cargarEjemplaresLibro(),cargarEjemplaresPresLibro(),estadoAlta(),selecccionaAuthor(),selecccionaEditorial());
                    break;
                case 2:
                    bookService.modificarNombreBook(buscarBook(1));
                    break;
                case 3:
                 bookService.eliminarBook(buscarBook(2));
                    break;
                 case 4:
                    bookService.imprimirBooks();
                    break;
                case 0:
                //    System.exit(0);
                    break;
            }

       

    }

    private String cargarTituloLibro() throws Exception {        
      //  boolean validar = false;
        String titulo;
             
            System.out.println("TITULO del libro: ");
            titulo = sc.next().toLowerCase();
            //validar = validarEditorial(titulo);    //validar si existe        
             
        
        return titulo;
    }
    private Integer cargarAnioLibro(){
        Integer anio;                  
        System.out.println("Año del libro: ");
            anio = sc.nextInt();
        return anio;
    }
    private Integer cargarEjemplaresLibro() {
        Integer ejemplares;                  
        System.out.println("Cant. ejemplares libro: ");
            ejemplares = sc.nextInt();
        return ejemplares;
    }    
    private Integer cargarEjemplaresPresLibro(){
        Integer ejemplaresPres;                  
        System.out.println("Cantidad Presados: ");
            ejemplaresPres = sc.nextInt();
        return ejemplaresPres;
    }
    
    private boolean estadoAlta() {        
        return true;
    }
    private void verAutores() throws Exception{
        System.out.println("LISTA DE AUTORES");
        Collection <Author> autores=bookService.listAuthor();
        for (Author autor : autores) {
            System.out.println(autor.getNombre()); 
        }
    }
    private Author selecccionaAuthor() throws Exception{
        verAutores();
        System.out.println("Ingrese autor del libro");
        String nombre=sc.next();
        Author autor=bookService.buscarAuthor(nombre); 
        return autor;
    }
    private void verEditorial() throws Exception{
        System.out.println("LISTA DE EDITORIALES");
        Collection <Editorial> editoriales=bookService.listEditorial();
        for (Editorial editorial : editoriales) {
            System.out.println(editorial.getNombre()); 
        }
    }
    private Editorial selecccionaEditorial() throws Exception{
        verEditorial();
        System.out.println("Ingrese la editorial del libro");
        String nombre=sc.next();
        Editorial editorial=bookService.buscarEditorial(nombre);        
        return editorial;
    }
    
     public String buscarBook(int opcion) {
         if (opcion==1) {
             System.out.println("Que libro desea Modificar "); 
         }
         if(opcion==2){
             System.out.println("Que libro desea Eliminar "); 
         }
        String nombre = sc.next();    
        return nombre;
    }
//    public boolean validarEditorial(String nombre) throws Exception {
//        boolean validar = false;
//        try {
//            Collection<Editorial> editoriales = BookServicio.listaEditorials();
//            for (Editorial u : editoriales) {
//                if (u.getNombre().equalsIgnoreCase(nombre)) {                    
//                    System.out.println("El nombre del Editorial exite!");
//                    validar = true;
//                    // throw new Exception("El editorial ya existe, ingrese otro editorial");
//                    
//                }
//            }
//            
//        } catch (Exception e) {
//            throw e;
//        }
//        
//        return validar;
//    }


}
