package uniandes.dpoo.taller7.interfaz2;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Juego de LightsOut");
        setSize(525, 469);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Agrega los paneles
        add(new PanelSuperior(), BorderLayout.NORTH);
        add(new PanelDerecho(), BorderLayout.EAST);
        add(new PanelInferior(), BorderLayout.SOUTH);

        // Hace que la ventana sea visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
