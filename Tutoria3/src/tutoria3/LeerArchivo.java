/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoria3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author González Chávez
 */
public class LeerArchivo {
    static Scanner lector = new Scanner(System.in);
    static Pokemon[] pokemones = new Pokemon[14];


    /*public static void main(String[] args) throws Exception {
        cargarArchivo();
        
        for (Pokemon pokemon : pokemones) {
            pokemon.imprimir();
        }
    }*/

    public LeerArchivo() {
    }

    public void cargarArchivo() {
        String ruta;
        ruta = lector.nextLine();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = br.readLine();
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String[] datos = linea.split(",");
                
                int id = Integer.parseInt(datos[0]);
                String tipo = datos[1];
                String nombre = datos[2];
                double vida = Double.parseDouble(datos[3]);
                double puntosAtaque = Double.parseDouble(datos[4]);
                boolean capturado, estado;

                if (datos[5].equalsIgnoreCase("salvaje")) {
                    capturado = false;                    
                } else {
                    capturado = true;
                }

                if (datos[6].equalsIgnoreCase("muerto")) {
                    estado = false;
                } else {
                    estado = true;
                }

                Pokemon nuevoPokemon = new Pokemon(id, tipo, nombre, vida, puntosAtaque, capturado, estado);

                pokemones[contador] = nuevoPokemon;
                contador += 1;


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
