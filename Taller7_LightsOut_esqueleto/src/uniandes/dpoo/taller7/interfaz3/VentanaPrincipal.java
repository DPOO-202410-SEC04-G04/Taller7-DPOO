package uniandes.dpoo.taller7.interfaz3;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.*;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private PanelSuperior panelSuperior;
    private PanelTablero panelTablero;

    public VentanaPrincipal() {
        setTitle("Juego de LightsOut");
        setSize(569, 427);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new PanelSuperior();
        panelTablero = new PanelTablero(5);  // Inicializa con un tablero 5x5
        add(panelSuperior, BorderLayout.NORTH);
        add(new PanelDerecho(), BorderLayout.EAST);
        add(new PanelInferior(), BorderLayout.SOUTH);
        add(panelTablero, BorderLayout.CENTER);

        panelSuperior.getComboBoxTamanio().addActionListener(e -> {
            String seleccion = (String) panelSuperior.getComboBoxTamanio().getSelectedItem();
            int tamano = Integer.parseInt(seleccion.split("x")[0]);
            panelTablero.setTamano(tamano);
            panelTablero.revalidate();
            panelTablero.repaint();
        });

        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
