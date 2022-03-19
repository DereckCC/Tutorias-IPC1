package tutoria5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {

    JPanel panel;
    JTable tabla;
    static Producto[] productos;

    public Ventana() {
        //ddefiniendo el arreglo
        productos = new Producto[10];
        //definiendo el frame
        this.setSize(800, 400);
        this.setLayout(null);
        this.setTitle("Ejemplo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel(this);
    }

    public void panel(JFrame frame) {
        informacion();
        panel = new JPanel();
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(new Color(135, 206, 235));
        frame.getContentPane().add(panel);
        
        //instanciamos los hilos 
        MetodoBurbuja o1 = new MetodoBurbuja(panel);
        MetodoInsercion m1= new MetodoInsercion(panel);

        //definiendo el boton
        JButton boton = new JButton("Burbuja");
        boton.setBounds(650, 30, 130, 40);
        boton.setLayout(null);
        boton.setVisible(true);
        panel.add(boton);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                o1.start();
            }
        });

        //definiendo el boton
        JButton boton2 = new JButton("Insercion");
        boton2.setBounds(650, 90, 130, 40);
        boton2.setLayout(null);
        boton2.setVisible(true);
        panel.add(boton2);

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m1.start();
            }
        });
    }

    public void informacion() {
        Producto c1 = new Producto("Arándano", 2.5, 300);
        Producto c2 = new Producto("Frambuesa", 3.5,230);
        Producto c3 = new Producto("Fresa", 5, 290);
        Producto c4 = new Producto("Limón", 4.5, 250);
        Producto c5 = new Producto("Mandarina", 3.5, 270);
        
        Producto c6 = new Producto("Melón", 2.5, 30);
        Producto c7 = new Producto("Sandía", 3.5, 180);
        Producto c8 = new Producto("Coco", 5, 70);
        Producto c9 = new Producto("Piña", 4.5, 200);
        Producto c10 = new Producto("Kiwi", 3.5, 100);

        productos[0] = c1;
        productos[1] = c2;
        productos[2] = c3;
        productos[3] = c4;
        productos[4] = c5;
        productos[5] = c6;
        productos[6] = c7;
        productos[7] = c8;
        productos[8] = c9;
        productos[9] = c10;
    }
}
