
package ejemplo;

public class Persona {
    //atributos
    private String nombre;
    private String apellido;
    
    //constructor de 2 parametros
    public Persona (String nombre, String apellido){
        setNombre(nombre);
        setApellido(apellido);
    }
    
    //metodos de acceso sets y gets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
