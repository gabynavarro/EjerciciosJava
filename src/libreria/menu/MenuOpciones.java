package libreria.menu;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;


public class MenuOpciones {
/*Recordar que este menu es a modo de orden para ir probando los metodos, no tiene importancia
    en si, ya que muy pronto los datos seran recibidos desde los formularios de las paginas web*/
    private final Scanner sc;
    private MenuEitorial menuEditorial;
    private MenuAuthor menuAuthor;
    private MenuLibro menuBook;
      
   
    public MenuOpciones() {
        this.sc = new Scanner(System.in);
        this.menuAuthor=new MenuAuthor();
        this.menuBook=new  MenuLibro();
        this.menuEditorial=new  MenuEitorial();
    }

    public void menu() throws Exception {
     
        String respuesta;
        do {
            System.out.println("MENU LIBRERIA:");
            System.out.println("===============");
            System.out.println(" 1- Author");//OK
            System.out.println(" 2- Editorial");//OK
            System.out.println(" 3- Libro");//OK
            System.out.println(" 0- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                  menuAuthor.menu();
                    break;
                case 2:
                  menuEditorial.menu();
                    break;
                case 3:
                   menuBook.menu();
                    break;                           
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("Desea realizar una nueva consulta o gestion ???:SI/NO");
            respuesta = sc.next();
            respuesta = respuesta.toUpperCase();
            limpiarPantalla();
        } while ("SI".equals(respuesta));

    }

    public void limpiarPantalla() throws AWTException {
        //Dejo esre metodo para ir borrando la consola.. y que no sea un desorden.
        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30); // Tiempo de espera antes de borrar
        pressbot.keyPress(17); // Orden para apretar CTRL key
        pressbot.keyPress(76);// Orden para apretar L key
        pressbot.keyRelease(17); // Orden para soltar CTRL key
        pressbot.keyRelease(76); // Orden para soltar L key

    }

}
