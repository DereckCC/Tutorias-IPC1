package tutoria5;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MetodoInsercion extends Thread {

    JPanel panel;
    JLabel grafica_personas;

    public MetodoInsercion(JPanel panel) {
        this.panel = panel;
        //contenedor para la grafica 
        grafica_personas = new JLabel();
        grafica_personas.setBounds(20, 20, 620, 300);
        grafica_personas.setOpaque(true);
        grafica_personas.setVisible(true);
        grafica_personas.setBackground(Color.WHITE);
        panel.add(grafica_personas);
        grafica_barras(panel, grafica_personas);
    }

    @Override
    public void run() {
        try {
            int j;
            Producto aux;
            for (int i = 1; i < Ventana.productos.length; i++) { // desde el segundo elemento hasta
                aux = Ventana.productos[i];           // el final, guardamos el elemento y
                j = i - 1;            // empezamos a comprobar con el anterior
                while ((j >= 0) && (aux.getCantidad() < Ventana.productos[j].getCantidad())) {// mientras queden posiciones y el
                    //Thread.sleep(1000);
                    Ventana.productos[j + 1] = Ventana.productos[j];      // valor de aux sea menor que los de la izquierda, se desplaza a
                    j--;// la derecha
                    grafica_barras(panel, grafica_personas);  
                }
                Ventana.productos[j + 1] = aux;      // colocamos aux en su sitio
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Error al Ordenar");
        }
    }

    public void grafica_barras(JPanel panel, JLabel grafica_personas) {
        try {
            DefaultCategoryDataset datos = new DefaultCategoryDataset();  // guardaremos la informacion para la grafica
            for (int i = 0; i < Ventana.productos.length; i++) {
                datos.setValue(Ventana.productos[i].getCantidad(), "", Ventana.productos[i].getNombre());
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
}
