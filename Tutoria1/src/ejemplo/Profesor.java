
package ejemplo;


public class Profesor  extends Persona{
    //atributos
    private int dpi;
    public static int contador;     //variable globar que llevara el control de donde coloar los
                                    //nuevos datos que se agregaran en el arreglo
    
    //constructor de 2 atributos
    public Profesor(String nombre, String apellido, int dpi) {
        super(nombre, apellido);
        setDpi(dpi);
    }

    //metodos set y get
    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    //metodo para hacer la impresion del objeto
    @Override
    public String toString() {
        return "nombre: " + super.getNombre() + "\napellido: " +super.getApellido() +"\ndpi: " + dpi;
    }
    
    
    
}
