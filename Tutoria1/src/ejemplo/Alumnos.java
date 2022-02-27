package ejemplo;

public class Alumnos extends Persona {
    //atributos
    private int carnet;
    public static int contador;      //variable globar que llevara el control de donde coloar los
                                    //nuevos datos que se agregaran en el arreglo
    
    
    //constructor de 2 parametros
    public Alumnos(String nombre, String apellido, int carne) {
        super(nombre, apellido);
        setCarnet(carne);
    }

    //metodo set y get  
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    //metodo para hacer la impresion del objeto
    @Override
    public String toString() {
        return "nombre: " + super.getNombre() + "\nApellido: " + super.getApellido() + "\nCarne: " + carnet;
    }
}
