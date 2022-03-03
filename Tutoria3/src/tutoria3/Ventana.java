/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. C:\Users\González Chávez\Documents\erick\Practicas Iniciales\Repositoriotutotiras\Repo\Tutoria2\pokemon.csv
 */
package tutoria3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author González Chávez
 */
public class Ventana {
    JFrame inicio_login, ventana_pokemones;
    JPanel panel_login, panel_pokemones, panel_tabla_pokemones;
    JButton boton_login, carga_masiva;
    JTextField tf_login;
    JPasswordField pf_login;
    DefaultTableModel modelo_tabla_pokemones;
    JTable tabla_pokemones;
    
    public void Ventana(){
        /////////Ventanas
        inicio_login = new JFrame("Login");
        inicio_login.setVisible(false);
        inicio_login.setLayout(null);
        inicio_login.setBounds(200, 200, 600, 200);
        inicio_login.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ventana_pokemones = new JFrame("Pokemones");
        ventana_pokemones.setVisible(true);
        ventana_pokemones.setLayout(null);
        ventana_pokemones.setBounds(200, 200, 800, 500);
        ventana_pokemones.setDefaultCloseOperation(EXIT_ON_CLOSE);
        /////////PANELES
        panel_login = new JPanel();
        panel_login.setVisible(true);
        panel_login.setBounds(0, 0, 600, 200);
        panel_login.setVisible(true);
        panel_login.setBackground(Color.red);
        
        inicio_login.add(panel_login);
        
        boton_login = new JButton("Entrar");
        boton_login.setVisible(true);
        boton_login.setBounds(200, 300, 50, 20);
        
        panel_login.add(boton_login);
        
        tf_login = new JTextField();
        tf_login.setVisible(true);
        tf_login.setBounds(100, 20, 100, 20);
        
        panel_login.add(tf_login);
        
        pf_login = new JPasswordField();
        pf_login.setVisible(true);
        pf_login.setBounds(100, 60, 100, 20);
        
        panel_login.add(pf_login);
        
        panel_pokemones = new JPanel();
        panel_pokemones.setVisible(true);
        panel_pokemones.setBounds(0, 0, 800, 500);
        panel_pokemones.setBackground(Color.blue);
        panel_pokemones.setLayout(null); ///Faltaba agregar esto
        
        ventana_pokemones.add(panel_pokemones);
        
        modelo_tabla_pokemones = new DefaultTableModel();
        tabla_pokemones = new JTable(modelo_tabla_pokemones);
        modelo_tabla_pokemones.addColumn("Tipo");
        modelo_tabla_pokemones.addColumn("Nombre");
        modelo_tabla_pokemones.addColumn("Capturado");
        
        
        
        panel_tabla_pokemones = new JPanel();
        panel_tabla_pokemones.setVisible(true);
        panel_tabla_pokemones.setBounds(50, 40, 400, 300);
        panel_tabla_pokemones.setBackground(Color.red);
        panel_tabla_pokemones.setLayout(new BorderLayout());///FALTABA AGREGAR ESTO EN EL LAYOUT

        panel_tabla_pokemones.add(new JScrollPane(tabla_pokemones));
        panel_pokemones.add(panel_tabla_pokemones);
        
        carga_masiva = new JButton("Carga Masiva");
        carga_masiva.setVisible(true);
        carga_masiva.setLayout(null);
        carga_masiva.setBounds(500, 200, 100, 20);
        
        panel_pokemones.add(carga_masiva);
        
        boton_login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(("admin".equals(tf_login.getText()))&&("admin".equals(pf_login.getText()))){
                    inicio_login.setVisible(false);
                    ventana_pokemones.setVisible(true);
                }
            }
        });
        
        
        carga_masiva.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LeerArchivo leyendo = new LeerArchivo();
                leyendo.cargarArchivo();
            }
        });
        
    }
}
