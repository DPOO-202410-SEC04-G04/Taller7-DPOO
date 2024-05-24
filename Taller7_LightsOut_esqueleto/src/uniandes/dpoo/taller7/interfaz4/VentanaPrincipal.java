package uniandes.dpoo.taller7.interfaz4;

import javax.swing.JFrame;

import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private PanelSuperior panelSuperior;
    private PanelTablero panelTablero;
    private PanelDerecho panelDerecho;
	private PanelInferior panelInferior;

    public VentanaPrincipal() {
    	Top10 top10 = new Top10();
    	File archivoTop10 = new File(".\\data\\top10.csv"); 
    	top10.cargarRecords(archivoTop10);
    	
    	
        setTitle("Juego de LightsOut");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new PanelSuperior(panelTablero);
        panelTablero = new PanelTablero(5);  // Inicializa con un tablero 5x5
        add(panelTablero, BorderLayout.CENTER);
        

        add(panelSuperior, BorderLayout.NORTH);
        panelInferior = new PanelInferior(); 
        add(panelInferior, BorderLayout.SOUTH);
        
        ActionListener nuevoListener = e -> {
            int tamano = panelSuperior.getTamanoSeleccionado();
            String dificultad = panelSuperior.getDificultadSeleccionada();
            panelTablero.setTamano(tamano);
            panelTablero.reiniciar(dificultad);
        };

        ActionListener reiniciarListener = e -> {
            // Lógica para reiniciar el juego
        	 panelTablero.reiniciarTablero();
        	
        };

        ActionListener top10Listener = e -> {
            // Lógica para mostrar top 10
        	 new TopTenDialog(this, top10);
        	
        };

        ActionListener cambiarJugadorListener = e -> {
            // Lógica para cambiar jugador
        };

        panelDerecho = new PanelDerecho(nuevoListener, reiniciarListener, top10Listener, cambiarJugadorListener, this);

        add(panelDerecho, BorderLayout.EAST);

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
    

    public void cambiarNombreJugador() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del jugador:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            panelInferior.setNombreJugador(nombre); // Establece el nombre del jugador en el panel inferior
        }
    }
    public static void main(String[] args) {
        new VentanaPrincipal();
    }
    
    
}
