
package ejemplo;

public class Datos {
    public Alumnos [] arg_alumnos;          //arreglo para almacenar la informacion de alumnos
    public Profesor [] arg_profesor;        // arreglo para almacenar la informacion de profesores
    
    public Datos (){
        arg_alumnos= new Alumnos[5];        //instanciando los arreglos 
        arg_profesor= new Profesor[5];
        
        
        //creando los objetos de alumnos
        Alumnos a1 = new Alumnos("juan", "suarez", 5323223);    
        Alumnos a2 = new Alumnos("a", "a12", 232323);
        Alumnos a3 = new Alumnos("b", "a34", 3232323);


       
        arg_alumnos[Alumnos.contador]=a1; //agregando el objeto al arreglo
        Alumnos.contador++;         // aumentando en 1 la variable contador 
        arg_alumnos[Alumnos.contador]=a2;
        Alumnos.contador++;            
        arg_alumnos[Alumnos.contador]=a3;
        Alumnos.contador++;          
        impresion(arg_alumnos);     //llamando el metodo para imprimir el arreglo
        
        System.out.println("********Modificacion nombre**********");
        modificarNombreAlumnos(232323, "mario");  //llamando el metodo para modificar datos de un alumno
        impresion(arg_alumnos);//llamando el metodo para imprimir el arreglo
        
        System.out.println("Busqueda ");
        System.out.println(buscarAlumno(3232323)); //imprimiendo la informacion de un alumno por su carne
        
        
        //creando los objetos de profesores
        System.out.println("\nProfesor");
        Profesor p1 = new Profesor("mario", "lazio", 2323330);      
        Profesor p2 = new Profesor("asdas", "aaaa", 2323330);
        Profesor p3 = new Profesor("asddddd", "bbbb", 2323330);
        
        arg_profesor[Profesor.contador]=p1;     //agregando cada objeto al arreglo
        Profesor.contador++;                    //aumentando el contador de profesores
        arg_profesor[Profesor.contador]=p2;
        Profesor.contador++;
        arg_profesor[Profesor.contador]=p3;
        Profesor.contador++;
        impresion(arg_profesor);    //imprimiendoo el arreglo de profesores
    }
    
    
    //metodo para imprimir cualquier arreglo
    public void impresion (Object [] arg){
        for (int i = 0; i < arg.length; i++) {
            if (arg[i]!=null) {
                System.out.println(arg[i]+"\n");
            }else{
                break;
            }
        }
    }
    
    
    //metodo para modificar el nombre de un alumno por medio de su carne
    public void modificarNombreAlumnos (int carne, String nombre){
        int posicion= buscarAlumno(carne);
        arg_alumnos[posicion].setNombre(nombre);
    }
    
    
    //metodo para buscar un alumno por su carne
    public int buscarAlumno (int carne){
        int respuesta=0;
        for (int i = 0; i < arg_alumnos.length; i++) {      //se hace el recorrido del arreglo
            if (arg_alumnos[i]!=null) {                     // condicion que se ejecuta siempre y cuando o tenga campos vacios
                if (arg_alumnos[i].getCarnet()==carne) {    //condicion a evaluar
                    respuesta=i;
                    break;
                }
            }else{
                break;
            }
        }
        return respuesta;
    }
}
