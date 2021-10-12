
package libreria.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity// Esta anotacion, avisa que esta clase se convertira en TABLA

 public class Author {   
    @Id
    @GeneratedValue    
    private Integer id;
    @Column(unique = true)
    private String nombre;
    private Boolean alta;

    public Author() {
    }
    
    public Author(Integer id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
//     @Override
//    public String toString() {
//        return "Author{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
//    }
}
