/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoria3;

/**
 *
 * @author González Chávez
 */
public class Pokemon {
    int id;
    String tipo;
    String nombre;
    double vida;
    double puntosAtaque;
    boolean capturado;
    boolean estado;
    
    public Pokemon(int id, String tipo, String nombre, double vida, double puntosAtaque, boolean capturado,
            boolean estado) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.vida = vida;
        this.puntosAtaque = puntosAtaque;
        this.capturado = capturado;
        this.estado = estado;
    }

    public void imprimir() {
        String imprimirCap = this.capturado ? " si esta caputrado" : " no esta caputurado";
        String imprimirEstado = this.estado ? " vivo" : " muerto";
        System.out.println("------ POKEMON -----");
        System.out.println("ID: " + this.id);
        System.out.println("TIPO: " + this.tipo);
        System.out.println("NOMBRE: " + this.nombre);
        System.out.println("VIDA: " + this.vida);
        System.out.println("PUNTOS DE ATAQUE: " + this.puntosAtaque);
        System.out.println("CAPTURADO: " + imprimirCap);
        System.out.println("ESTADO: " + imprimirEstado);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(double puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }   
}
