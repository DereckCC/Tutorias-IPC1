
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.FileWriter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Ventana extends JFrame {

    JPanel panel;
    JTable tabla;
    Producto[] productos;
    String reporte ="<!DOCTYPE html>\n" +
"<html lang=\"es\">\n" +
"\n" +
"<head>\n" +
"    <title>Reporte</title>\n" +
"    <meta http-equiv=Content-Type content=text/html; charset=UTF-8>\n" +
"    <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"    <script src=\"script.js\"></script>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"    <section>\n" +
"        <h1>Reporte de Productos</h1>\n" +
"        <br>\n" +
"        <div class=\"tbl-header\">\n" +
"            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                <thead>\n" +
"                    <tr>\n" +
"                        <th>Nombre</th>\n" +
"                        <th>Cantidad</th>\n" +
"                        <th>Precio</th>\n" +
"                    </tr>\n" +
"                </thead>\n" +
"            </table>\n" +
"        </div>\n" +
"        <div class=\"tbl-content\">\n" +
"            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                <tbody>";

    public Ventana() {
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
        panel = new JPanel();
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(new Color(135, 206, 235));
        frame.getContentPane().add(panel);
        
        //definiendo el boton
        JButton boton = new JButton("Generar Reporte");
        boton.setBounds(600, 150, 140, 40);
        boton.setLayout(null);
        boton.setVisible(true);
        panel.add(boton);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reporte ();
            }
        });
        
        def_tabla(panel);
    }

    public void def_tabla(JPanel panel) {
        //obteniendo la informacion
        informacion();
        tabla = new JTable();
        DefaultTableModel modelo = new DefaultTableModel();
        //encabezados
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");

        //datos
        tabla.setModel(modelo);
        tabla.setEnabled(false);
        JScrollPane barra = new JScrollPane(tabla);
        barra.setBounds(200, 15, 400, 120);
        panel.add(barra);

        llenado_tabla(modelo, productos);
        grafica_barras(productos, panel);
        grafica_pie(productos, panel);
    }

    public void llenado_tabla(DefaultTableModel modelo, Producto[] productos) {
        DefaultTableModel df = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            df.removeRow(df.getRowCount() - 1);
        }

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                String datos[] = new String[5];
                datos[0] = String.valueOf(productos[i].getNombre());
                datos[1] = String.valueOf(productos[i].getCantidad());
                datos[2] = String.valueOf(productos[i].getPrecio());
                modelo.addRow(datos);
            } else {
                break;
            }
        }
    }

    public void informacion() {
        productos = new Producto[5];
        Producto c1 = new Producto("Manzana",2.5,30);
        Producto c2 = new Producto("Pera", 3.5, 20);
        Producto c3 = new Producto("Melon", 5, 25);
        Producto c4 = new Producto("Mango", 4.5, 15);
        Producto c5 = new Producto("Fresa", 3.5, 18);

        productos[0] = c1;
        productos[1] = c2;
        productos[2] = c3;
        productos[3] = c4;
        productos[4] = c5;
    }
    
    public void grafica_barras(Producto [] productos, JPanel panel){
        try {
            //contenedor para la grafica 
            JLabel grafica_personas = new JLabel();
            grafica_personas.setBounds(15, 140, 240, 200);
            grafica_personas.setOpaque(true);
            grafica_personas.setVisible(true);
            grafica_personas.setBackground(Color.WHITE);
            panel.add(grafica_personas);
            
            DefaultCategoryDataset datos = new DefaultCategoryDataset();  // guardaremos la informacion para la grafica
            for (int i = 0; i < productos.length; i++) {
                datos.setValue(productos[i].getCantidad(),"", productos[i].getNombre());
            }
            JFreeChart ct = ChartFactory.createBarChart3D("Grafica de Productos" //titulo de grafica
                    ,
                     "" // nombre de eje x
                    ,
                     "", // nombre eje y
                    datos, // informacion que usará
                    PlotOrientation.VERTICAL,// orientacion de la grafica 
                    false,// lengenda de barras individuales por color  
                    true,// herramientas
                    false);// url de grafico
            
            ChartPanel panel_grafica = new ChartPanel(ct);
            panel_grafica.setMouseWheelEnabled(true);

            grafica_personas.setLayout(new java.awt.BorderLayout());
            grafica_personas.add(panel_grafica, BorderLayout.CENTER);
            grafica_personas.validate();            
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void grafica_pie(Producto[] productos, JPanel panel) {
        try {
            JLabel grafica_vendedores = new JLabel();
            grafica_vendedores.setBounds(270, 140, 240, 200);
            grafica_vendedores.setOpaque(true);
            grafica_vendedores.setVisible(true);
            grafica_vendedores.setBackground(Color.WHITE);
            panel.add(grafica_vendedores);

            DefaultPieDataset datos = new DefaultPieDataset(); //aqui se guarda la informacion de la grafica 
            for (int i = 0; i < productos.length; i++) {
                datos.setValue(productos[i].getNombre(), productos[i].getCantidad());
            }

            PieSectionLabelGenerator etiqueta = new StandardPieSectionLabelGenerator("{0} = {1}"); // coloca los datos del nombre y cantidad
            JFreeChart jf = ChartFactory.createPieChart("Cantidad Productos" //titulo de grafica
                    , datos, //informacion a utilizar
                    true, //coloca una caja de los significados de los colores
                    false, // no me acuerdo :'v
                    false); // no me acuerdo :'v x2
            
            PiePlot pl = (PiePlot) jf.getPlot();
            pl.setLabelGenerator(etiqueta);

            ChartPanel panel_grafica = new ChartPanel(jf);
            panel_grafica.setMouseWheelEnabled(true);

            grafica_vendedores.setLayout(new java.awt.BorderLayout());
            grafica_vendedores.add(panel_grafica, BorderLayout.CENTER);
            grafica_vendedores.validate();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void reporte (){
        File archivoHtml;
        FileWriter escritor = null;
        try {
            archivoHtml = new File ("index.html");
            escritor= new FileWriter(archivoHtml);
            
            for (int i = 0; i < productos.length; i++) {
                reporte +="                    <tr>\n" +
"                        <td>"+productos[i].getNombre()+"</td>\n" +
"                        <td>"+productos[i].getCantidad()+"</td>\n" +
"                        <td>"+productos[i].getPrecio()+"</td>\n" +
"                    </tr>";    
            }
            reporte +="                </tbody>\n" +
"            </table>\n" +
"        </div>\n" +
"    </section>\n" +
"</body>\n" +
"</html>";
            escritor.write(reporte);
            System.out.println("Reporte creado");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                escritor.close();
            } catch (Exception e) {
            }
        }
 
    }
}
